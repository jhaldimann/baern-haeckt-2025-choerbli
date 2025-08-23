import {inject, Injectable} from '@angular/core';
import {Choerbli, Summary} from '../models/choerbli.model';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChoerbliApiService {
  private http: HttpClient = inject(HttpClient);
  private baseUrl: string = 'http://localhost:8080';

  createChoerbli(choerbli: Choerbli): Observable<Choerbli> {
    const formData = new FormData();
    formData.append('creationDto', new Blob([JSON.stringify(choerbli)], { type: 'application/json' }));
    return this.http.post<Choerbli>(this.baseUrl+'/api/choerbli/create', formData);
  }

  getChoerbli(id: string) {
    return this.http.get<Choerbli>(this.baseUrl+'/api/choerbli/'+id);
  }

  getSummary(id: string) {
    return this.http.get<Summary>(this.baseUrl+'/api/choerbli/summary/'+id);
  }
}
