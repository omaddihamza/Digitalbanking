import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  token!:string;

  constructor() { }

  public getToken(){
    return this.token;
  }

  public setToken(token:any){
        this.token = token;
  }

}
