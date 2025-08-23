import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PhaseApiService {
  private http: HttpClient = inject(HttpClient);
  private baseUrl: string = 'http://localhost:8080';

  toAssigningPhase(id: string): Observable<void> {
    return this.http.patch<void>(this.baseUrl+'/api/choerbli/'+id+'/assigning', null);
  }
  toFinishPhase(id: string): Observable<void> {
    return this.http.patch<void>(this.baseUrl+'/api/choerbli/'+id+'/finish', null);
  }
}
