import {inject, Injectable} from '@angular/core';
import {Choerbli} from '../models/choerbli.model';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Consequence} from '../models/consequence.model';

@Injectable({
  providedIn: 'root'
})
export class ConsequenceApiService {
  private http: HttpClient = inject(HttpClient);
  private baseUrl: string = 'http://localhost:8080';

  createConsequences(consequences: Consequence[]): Observable<Consequence[]> {
    const formData = new FormData();
    formData.append('creationDtos', new Blob([JSON.stringify(consequences)], { type: 'application/json' }));
    return this.http.post<Consequence[]>(this.baseUrl+'/api/consequence/create', formData);
  }
}
