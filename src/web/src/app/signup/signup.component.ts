import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { Signup } from '../_model/signup';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  signup = new Signup();  

  constructor(private authService:AuthService){

  }

  ngOnInit(): void {
    
  }

  onSignup(){
    this.authService.signUp(this.signup).subscribe(response=>{
        this.signup = response;
    })
  }

}
