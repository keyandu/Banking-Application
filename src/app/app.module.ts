import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './layout/header/header.component';
import { MainComponent } from './page/main/main.component';
import { LoginComponent } from './page/login/login.component';
import { SignUpComponent } from './page/sign-up/sign-up.component';
import { StaffLoginComponent } from './page/staff-login/staff-login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { StaffRegisterComponent } from './page/staff-register/staff-register.component';
import { StaffdashboardComponent } from './page/staffdashboard/staffdashboard.component';
import { TransferComponent } from './page/transfer/transfer.component';
import { StaffByAccountNumberComponent } from './page/staff-by-account-number/staff-by-account-number.component';
import { StaffApproveAccountComponent } from './page/staff-approve-account/staff-approve-account.component';
import { StaffEnableDisableCustomerComponent } from './page/staff-enable-disable-customer/staff-enable-disable-customer.component';
import { StaffApproveBeneficiaryComponent } from './page/staff-approve-beneficiary/staff-approve-beneficiary.component';
import { StaffTransferComponent } from './page/staff-transfer/staff-transfer.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    HeaderComponent,
    LoginComponent,
    SignUpComponent,
    StaffLoginComponent,
    StaffRegisterComponent,
    StaffdashboardComponent,
    TransferComponent,
    StaffByAccountNumberComponent,
    StaffApproveAccountComponent,
    StaffEnableDisableCustomerComponent,
    StaffApproveBeneficiaryComponent,
    StaffTransferComponent,
 
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
