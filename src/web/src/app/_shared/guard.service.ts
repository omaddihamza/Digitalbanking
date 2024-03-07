import { Injectable } from '@angular/core';
import { Router, RouterStateSnapshot } from '@angular/router';
import { TokenService } from './token.service';
import { CustomJwtPayload } from '../_model/jwt';
import { jwtDecode } from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class GuardService {

  constructor(private router:Router, private tokenService:TokenService) { }
  canActivate(route:RouterStateSnapshot, state:RouterStateSnapshot):boolean{
    
    const token = this.tokenService.getToken()
    if (!token) {
      this.router.navigate(['']);
      return false;
    }
  

    try {
      const decodedToken: any = jwtDecode(token);
      const userRole = decodedToken.roles[0].authority;

      if (userRole === 'ADMIN' && state.url.startsWith('/admin')) {
        return true;
      } else if (userRole === 'USER' && state.url.startsWith('/user')) {
        return true;
      } else {
        this.router.navigate(['']); // Redirect to login for unauthorized access
        return false;
      }
    } catch (error) {
      console.log('Token decoding error', error);
      this.router.navigate(['']); // Redirect to login if token decoding fails
      return false;
    }

    
  }
}
