import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ItemDescription} from '../models/item-description.model';

@Injectable({
  providedIn: 'root'
})
export class ItemDescriptionApiService {
  private http: HttpClient = inject(HttpClient);
  private baseUrl: string = 'http://localhost:8080';

  getItemDescription(): Observable<ItemDescription[]> {
    return this.http.get<ItemDescription[]>(this.baseUrl+'/api/item/descriptions');
  }

  setUserToItem(itemId: string, userId: string): Observable<void> {
    return this.http.patch<void>(this.baseUrl+'/api/item/'+itemId+'/assign/'+userId, null);
  }
}
