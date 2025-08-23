import {Component, inject, OnInit} from '@angular/core';
import {Item} from './item/item';
import {AsyncPipe, LowerCasePipe} from '@angular/common';
import {ItemDescriptionApiService} from '../../shared/services/item-description-api.service';
import {BehaviorSubject, take} from 'rxjs';
import {ItemDescription} from '../../shared/models/item-description.model';
import {ChoerbliStore} from '../../shared/stores/choerbli-store';
import {UserStore} from '../../shared/stores/user-store';
import {UserForm} from '../../shared/components/user-form/user-form';
import {Button} from 'primeng/button';
import {User} from '../../shared/models/user.model';
import {Card} from 'primeng/card';
import {ChoerbliStatus} from '../../shared/models/choerbli.model';
import {AssigningForm} from '../../shared/components/assigning-form/assigning-form';

@Component({
  selector: 'app-choerbli',
  imports: [
    Item,
    LowerCasePipe,
    AsyncPipe,
    UserForm,
    Button,
    Card,
    AssigningForm
  ],
  templateUrl: './choerbli.html',
  styleUrl: './choerbli.scss'
})
export class Choerbli implements OnInit {
  itemDescriptionApiService: ItemDescriptionApiService = inject(ItemDescriptionApiService);
  items: BehaviorSubject<ItemDescription[]> = new BehaviorSubject<ItemDescription[]>([]);
  id: string = '';
  readonly choerbliStore = inject(ChoerbliStore);
  readonly userStore = inject(UserStore);
  user: User = {email: '', id: '', name: '', choerbliId: ''};

  ngOnInit(): void {
    this.id = window.location.pathname.split('/')[2];
    this.itemDescriptionApiService.getItemDescription().pipe(take(1)).subscribe(data => {
      this.items.next(data);
    });
    this.choerbliStore.setChoerbliId(this.id);
    this.choerbliStore.loadChoerbliById(this.id);
  }

  getAllItemCategories(items: any): Set<string> {
    let categories: Set<string> = new Set<string>();
    items.forEach((item: any): void => {
      categories.add(item.category.name);
    })
    return categories;
  }

  createUser() {
    this.user.choerbliId = this.choerbliStore.choerbli()?.id ?? '';
    this.userStore.createUser(this.user);
  }

  protected readonly ChoerbliStatus = ChoerbliStatus;
}
