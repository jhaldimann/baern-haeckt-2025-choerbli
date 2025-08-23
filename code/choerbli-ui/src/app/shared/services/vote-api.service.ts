import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map, Observable} from 'rxjs';
import {ItemDescription} from '../models/item-description.model';
import {Choerbli} from '../models/choerbli.model';
import {Vote} from '../models/vote.model';
import {UserVoteInfo} from '../models/user-vote-info';

@Injectable({
  providedIn: 'root'
})
export class VoteApiService {
  private http: HttpClient = inject(HttpClient);
  private baseUrl: string = 'http://localhost:8080';


  createVote(userId: string, choerbliId: string, itemDescriptionId: string, factor: number): Observable<Vote> {
    const dataToSend  = {
      userId: userId,
      choerbliId: choerbliId,
      itemDescriptionId: itemDescriptionId,
      factor: factor
    }

    const formData = new FormData();
    formData.append('creationDto', new Blob([JSON.stringify(dataToSend)], { type: 'application/json' }));
    return this.http.post<Vote>(this.baseUrl+'/api/vote/create', formData);
  }

  updateVote(voteId: string, factor: number) {
    const dataToSend  = {
      id: voteId,
      factor: factor
    }

    const formData = new FormData();
    formData.append('updateDto', new Blob([JSON.stringify(dataToSend)], { type: 'application/json' }));
    return this.http.patch<Vote>(this.baseUrl+'/api/vote/update', formData);

  }

  getAllVotesFromOneUser(userId: string): Observable<Vote[]> {
    return this.http
      .get<UserVoteInfo>(`${this.baseUrl}/api/vote/vote-info/${userId}`)
      .pipe(map(resp => resp.votes));
  }
}
