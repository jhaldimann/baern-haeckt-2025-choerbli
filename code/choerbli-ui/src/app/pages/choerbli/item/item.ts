import {Component, inject, input} from '@angular/core';
import {VoteApiService} from '../../../shared/services/vote-api.service';
import {LocalStorageService} from '../../../shared/services/local-storage.service';
import {take} from 'rxjs';

@Component({
  selector: 'app-item',
  imports: [],
  templateUrl: './item.html',
  styleUrl: './item.scss'
})
export class Item {
  name = input('');
  itemId = input('');
  choerbliId = input('');
  voteApiService: VoteApiService = inject(VoteApiService);
  storageService: LocalStorageService = inject(LocalStorageService);

  downVote(): void {
    const user: any = localStorage.getItem('USER');
    const username = JSON.parse(user).id;
    const choerbliId = JSON.parse(user).choerbli.id;
    this.voteApiService.createVote(username, choerbliId, this.itemId(),-1).pipe(take(1)).subscribe();
  }

  upVote(): void {
    const user: any = localStorage.getItem('USER');
    const username = JSON.parse(user).id;
    const choerbliId = JSON.parse(user).choerbli.id;
    this.voteApiService.createVote(username, choerbliId, this.itemId(),1).pipe(take(1)).subscribe();
  }
}
