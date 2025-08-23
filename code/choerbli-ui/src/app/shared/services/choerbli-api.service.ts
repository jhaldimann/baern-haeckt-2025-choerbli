import {inject, Injectable} from '@angular/core';
import {Choerbli} from '../models/choerbli.model';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ChoerbliApiService {
  private http = inject(HttpClient);
  private baseUrl: string = 'http://localhost:8080';

  createChoerbli(choerbli: Choerbli) {
    const formData = new FormData();
    formData.append('creationDto', new Blob([JSON.stringify(choerbli)], { type: 'application/json' }));
    return this.http.post<Choerbli>(this.baseUrl+'/api/choerbli/create', formData);
  }
}
