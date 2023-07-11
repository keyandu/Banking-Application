import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './page/main/main.component';
import { BrowserModule } from '@angular/platform-browser';
import { CreateAcctComponent } from './page/create-acct/create-acct.component';
import { AddBeneficiaryComponent } from './page/add-beneficiary/add-beneficiary.component';
import { HomeComponent } from './page/home/home.component';
import { StatementComponent } from './page/statement/statement.component';
import { ProfileComponent } from './page/profile/profile.component';
import { StaffLoginComponent } from './page/staff-login/staff-login.component';
import { StaffdashboardComponent } from './page/staffdashboard/staffdashboard.component';
import { StaffApproveAccountComponent } from './page/staff-approve-account/staff-approve-account.component';
import { StaffApproveBeneficiaryComponent } from './page/staff-approve-beneficiary/staff-approve-beneficiary.component';
import { StaffByAccountNumberComponent } from './page/staff-by-account-number/staff-by-account-number.component';
import { StaffEnableDisableCustomerComponent } from './page/staff-enable-disable-customer/staff-enable-disable-customer.component';
import { AdminPortalComponent } from './page/admin-portal/admin-portal.component';
import { StaffTransferComponent } from './page/staff-transfer/staff-transfer.component';
const routes: Routes = [
  {path:'dashboard',component:MainComponent},
  {path:'create_account',component:CreateAcctComponent},
  {path:'add_beneficary',component:AddBeneficiaryComponent},
  {path:'home',component:HomeComponent},
  {path:'statement',component:StatementComponent},
  {path:'profile',component:ProfileComponent},
  {path:'staffLogin',component:StaffLoginComponent},
  {path:"staffDashboard",component:StaffdashboardComponent},
  {path:"staffApploveAccount",component:StaffApproveAccountComponent},
  {path:"staffApploveBeneficiary",component:StaffApproveBeneficiaryComponent},
  {path:"staffFindByAccountNumber",component:StaffByAccountNumberComponent},
  {path:"staffDisableOrEnableCustomer",component:StaffEnableDisableCustomerComponent},
  {path:"staffTransfer",component:StaffTransferComponent},
  {path:"admin",component:AdminPortalComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
