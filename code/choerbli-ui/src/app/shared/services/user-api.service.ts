import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../models/user.model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserApiService {
  private http = inject(HttpClient);
  private baseUrl: string = 'http://localhost:8080';

  createUser(user: User): Observable<User> {
    const formData = new FormData();
    formData.append('creationDto', new Blob([JSON.stringify(user)], { type: 'application/json' }));
    return this.http.post<User>(this.baseUrl+'/api/user/create', formData);
  }
}
