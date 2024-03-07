import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { Signup } from '../_model/signup';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {


  signup = new Signup();  

  constructor(private authService:AuthService, private router:Router){

  }

  ngOnInit(): void {
    
  }

  onSignup(){
    this.authService.signUp(this.signup).subscribe(response=>{
        this.router.navigate(['/signup-thanks'])
    })
  }

  goToSignIn() {
    this.router.navigate(['/signin'])
    }

}
