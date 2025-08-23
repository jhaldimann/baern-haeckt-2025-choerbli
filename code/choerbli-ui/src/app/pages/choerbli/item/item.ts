import {Component, EventEmitter, inject, Input, input, InputSignal, numberAttribute, Output} from '@angular/core';
import {VoteApiService} from '../../../shared/services/vote-api.service';
import {LocalStorageService} from '../../../shared/services/local-storage.service';
import {take} from 'rxjs';
import {NgClass} from '@angular/common';
import {Vote} from '../../../shared/models/vote.model';

@Component({
  selector: 'app-item',
  imports: [
    NgClass
  ],
  templateUrl: './item.html',
  styleUrl: './item.scss'
})
export class Item {
  @Output() somethingHappened = new EventEmitter<void>();
  name = input('');
  itemId = input('');
  choerbliId = input('');
  @Input() voteId!: string | undefined;
  @Input({transform: numberAttribute}) voteFactor!: number | undefined;
  voteApiService: VoteApiService = inject(VoteApiService);

  downVote(voteId: string | undefined): void {
    const user: any = localStorage.getItem('USER');
    const username = JSON.parse(user).id;
    const choerbliId = JSON.parse(user).choerbli.id;
    if(voteId) {
      this.voteApiService.updateVote(voteId, -1).pipe(take(1)).subscribe(d => {
        this.somethingHappened.emit();
      });
    } else {
      this.voteApiService.createVote(username, choerbliId, this.itemId(),-1).pipe(take(1)).subscribe(d => {
        this.somethingHappened.emit();
      });
    }


  }

  upVote(voteId: string | undefined): void {
    const user: any = localStorage.getItem('USER');
    const username = JSON.parse(user).id;
    const choerbliId = JSON.parse(user).choerbli.id;
    if(voteId) {
      this.voteApiService.updateVote(voteId, 1).pipe(take(1)).subscribe(d => {
        this.somethingHappened.emit();
      });
    } else {
      this.voteApiService.createVote(username, choerbliId, this.itemId(),1).pipe(take(1)).subscribe(d => {
        this.somethingHappened.emit();
      });
    }
  }
}
