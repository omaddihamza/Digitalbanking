import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { TokenService } from '../_shared/token.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  constructor(private userService:UserService, private tokenService:TokenService){}

  ngOnInit(): void {
    const token = this.tokenService.getToken()
    if(token){
      this.userService.getUserList(token).subscribe(response=>{
        console.log('User List', response);
      })
    }
    else{
      console.log('Token not found');
    }
  }

}
