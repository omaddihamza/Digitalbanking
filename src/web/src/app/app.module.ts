import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { FormsModule } from '@angular/forms';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { SignupThanksComponent } from './signup-thanks/signup-thanks.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { ProfileComponent } from './profile/profile.component';





@NgModule({
  declarations: [
    AppComponent,
    SigninComponent,
    SignupComponent,
    UserComponent,
    AdminComponent,
    SignupThanksComponent,
    HomeComponent,
    AboutComponent,
    ContactComponent,
    ProfileComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
