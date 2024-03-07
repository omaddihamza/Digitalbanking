import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { GuardService } from './_shared/guard.service';
import { SignupThanksComponent } from './signup-thanks/signup-thanks.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';


const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'about',component:AboutComponent},
  {path:'contact',component:ContactComponent},
  {path:'signin',component:SigninComponent}, 
  {path:'signup-thanks',component:SignupThanksComponent},
  {path:'signup',component:SignupComponent},
  {path:'admin',component:AdminComponent, canActivate:[GuardService]},
  {path:'user',component:UserComponent, canActivate:[GuardService]},
  {path: '**', redirectTo: '/signin' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
