import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  private apiUrl = "http://localhost:8080/api/users";

  constructor(private http:HttpClient) { }

  getUserList(token: string): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': 'Bearer '+token
    });
    return this.http.get<any>(this.apiUrl, { headers });
  }
}
