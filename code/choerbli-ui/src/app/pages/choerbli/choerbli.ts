import {Component, inject, OnInit} from '@angular/core';
import {Item} from './item/item';
import {AsyncPipe, LowerCasePipe} from '@angular/common';
import {ItemDescriptionApiService} from '../../shared/services/item-description-api.service';
import {BehaviorSubject, combineLatestWith, finalize, map, take} from 'rxjs';
import {ChoerbliStore} from '../../shared/stores/choerbli-store';
import {UserStore} from '../../shared/stores/user-store';
import {UserForm} from '../../shared/components/user-form/user-form';
import {Button} from 'primeng/button';
import {User} from '../../shared/models/user.model';
import {Card} from 'primeng/card';
import {ChoerbliStatus} from '../../shared/models/choerbli.model';
import {AssigningForm} from '../../shared/components/assigning-form/assigning-form';
import {PhaseApiService} from '../../shared/services/phase-api.service';
import {VoteApiService} from '../../shared/services/vote-api.service';
import {Vote} from '../../shared/models/vote.model';
import {ItemDescription} from '../../shared/models/item-description.model';
import {Ranking} from '../../shared/components/ranking/ranking';

@Component({
  selector: 'app-choerbli',
  imports: [
    Item,
    LowerCasePipe,
    AsyncPipe,
    UserForm,
    Button,
    Card,
    AssigningForm,
    Ranking
  ],
  templateUrl: './choerbli.html',
  styleUrl: './choerbli.scss'
})
export class Choerbli implements OnInit {
  itemDescriptionApiService: ItemDescriptionApiService = inject(ItemDescriptionApiService);
  phaseApiService: PhaseApiService = inject(PhaseApiService);
  voteApiService: VoteApiService = inject(VoteApiService);
  items: BehaviorSubject<myType[]> = new BehaviorSubject<myType[]>([]);
  id: string = '';
  readonly choerbliStore = inject(ChoerbliStore);
  readonly userStore = inject(UserStore);
  user: User = {email: '', id: '', name: '', choerbliId: ''};

  ngOnInit(): void {
    const user: any = localStorage.getItem('USER');
    const userId: any = JSON.parse(user)?.id;

    this.id = window.location.pathname.split('/')[2];
    this.updateItems(userId);
    this.choerbliStore.setChoerbliId(this.id);
    this.choerbliStore.loadChoerbliById(this.id);
  }

  getAllItemCategories(items: any): Set<string> {
    let categories: Set<string> = new Set<string>();
    items.forEach((item: any): void => {
      categories.add(item.item.category.name);
    })
    return categories;
  }

  createUser(): void {
    this.user.choerbliId = this.choerbliStore.choerbli()?.id ?? '';
    this.userStore.createUser(this.user);
  }

  nextPhase(): void {
    if (this.choerbliStore.choerbli().state === ChoerbliStatus.VOTING) {
      this.phaseApiService.toAssigningPhase(this.id).pipe(finalize((): void => this.choerbliStore.loadChoerbliById(this.id)),).subscribe(() => {
      });
    } else if (this.choerbliStore.choerbli().state === ChoerbliStatus.ASSIGNING) {
      this.phaseApiService.toFinishPhase(this.id).pipe(finalize((): void => this.choerbliStore.loadChoerbliById(this.id)),).subscribe(() => {
      });
    }
  }

  public updateItems(userId: string): void {
    this.itemDescriptionApiService.getItemDescription().pipe(
      combineLatestWith(this.voteApiService.getAllVotesFromOneUser(userId)),
      map(([items, votes]): myType[] => {

        return items.map(item => {
          const vote: Vote | undefined = votes.find(v => v.itemDescription.id === item.id);
          return { item: item, vote: vote};
        });
      })
    ).pipe(take(1)).subscribe(merged => this.items.next(merged));
  };

  onChildEvent(): void {
    const user: any = localStorage.getItem('USER');
    const userId = JSON.parse(user).id;
    this.updateItems(userId);
  }

  protected readonly ChoerbliStatus = ChoerbliStatus;


}

export type myType = {
  item: ItemDescription,
  vote: Vote | undefined
}
