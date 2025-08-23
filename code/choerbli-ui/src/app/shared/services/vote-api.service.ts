import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ItemDescription} from '../models/item-description.model';
import {Choerbli} from '../models/choerbli.model';
import {Vote} from '../models/vote.model';

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
}
