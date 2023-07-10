import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './layout/header/header.component';
import { MainComponent } from './page/main/main.component';
import { LoginComponent } from './page/login/login.component';
import { SignUpComponent } from './page/sign-up/sign-up.component';
import { HttpClientModule } from '@angular/common/http';
import { CreateAcctComponent } from './page/create-acct/create-acct.component';
import { FormsModule } from '@angular/forms';
import { AddBeneficiaryComponent } from './page/add-beneficiary/add-beneficiary.component';
import { HomeComponent } from './page/home/home.component';
import { StatementComponent } from './page/statement/statement.component';
import { ProfileComponent } from './page/profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    HeaderComponent,
    LoginComponent,
    SignUpComponent,
    CreateAcctComponent,
    AddBeneficiaryComponent,
    HomeComponent,
    StatementComponent,
    ProfileComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
