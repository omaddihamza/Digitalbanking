import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { Signin } from '../_model/signin';
import { SigninResponse } from '../_model/signinResponce';
import { Router } from '@angular/router';
import { jwtDecode } from "jwt-decode";
import { CustomJwtPayload } from '../_model/jwt';
import { TokenService } from '../_shared/token.service';
@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {


  signin = new Signin();

  constructor(private authService: AuthService, private router: Router, private tokenService:TokenService) { }

  ngOnInit(): void {

  }

  OnSignin() {
    this.authService.signIn(this.signin).subscribe((response: SigninResponse) => {
      const token = response.accessToken;
      this.tokenService.setToken(token);
      const decodedToken = jwtDecode<CustomJwtPayload>(token);
      const userRole = decodedToken.roles[0].authority;
      this.navigateBasedOnRole(userRole);
    },
      error => {
        console.log('Login Error', error);
      })
  }

  navigateBasedOnRole(userRole: string) {
    if (userRole === 'ADMIN') {
      this.router.navigate(['admin']);
    } else if (userRole === 'USER') {
      this.router.navigate(['user']);
    }
  }

  gotoSignUp() {
   this.router.navigateByUrl('/signup');
  }
}
