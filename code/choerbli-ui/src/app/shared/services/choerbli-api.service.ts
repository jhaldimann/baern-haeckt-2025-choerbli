import {inject, Injectable} from '@angular/core';
import {Choerbli} from '../models/choerbli.model';
import {HttpClient, HttpHeaders} from '@angular/common/http';
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
}
