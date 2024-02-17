import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { GuardService } from './_shared/guard.service';


const routes: Routes = [
  
  {path:'',component:SigninComponent}, 
  {path:'signup',component:SignupComponent},
  {path:'admin',component:AdminComponent, canActivate:[GuardService]},
  {path:'user',component:UserComponent, canActivate:[GuardService]},
  {path: '**', redirectTo: '/auth/signin' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
