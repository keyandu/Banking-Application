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
import { CreateAcctComponent } from './page/create-acct/create-acct.component';
import { AddBeneficiaryComponent } from './page/add-beneficiary/add-beneficiary.component';
import { HomeComponent } from './page/home/home.component';
import { StatementComponent } from './page/statement/statement.component';
import { ProfileComponent } from './page/profile/profile.component';
import { AdminPortalComponent } from './page/admin-portal/admin-portal.component';
import { StaffTransferComponent } from './page/staff-transfer/staff-transfer.component';
import { AdminLoginComponent } from './page/admin-login/admin-login.component';
import { AdminCreateStaffComponent } from './page/admin-create-staff/admin-create-staff.component';
import { AdminEnableStaffComponent } from './page/admin-enable-staff/admin-enable-staff.component';
import { CustomerLoginComponent } from './page/customer-login/customer-login.component';

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
    StaffLoginComponent,
    StaffRegisterComponent,
    StaffdashboardComponent,
    TransferComponent,
    StaffByAccountNumberComponent,
    StaffApproveAccountComponent,
    StaffEnableDisableCustomerComponent,
    StaffApproveBeneficiaryComponent,
    AdminPortalComponent,
    StaffTransferComponent,
    AdminLoginComponent,
    AdminCreateStaffComponent,
    AdminEnableStaffComponent,
    CustomerLoginComponent,
 
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
