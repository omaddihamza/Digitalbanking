import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map, tap } from 'rxjs';
import { Signin } from '../_model/signin';
import { Signup } from '../_model/signup';
import { SigninResponse } from '../_model/signinResponce';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private signinUrl = 'http://localhost:8080/api/auth/login';
  private signUpUrl = 'http://localhost:8080/api/auth/register';
  
  constructor(private http:HttpClient) { }

  signIn(signIn:Signin): Observable<SigninResponse> {
    return this.http.post<SigninResponse>(this.signinUrl,signIn);
  }

  signUp(sigUp: Signup): Observable<any> {
    return this.http.post(this.signUpUrl,sigUp);
  }

}


