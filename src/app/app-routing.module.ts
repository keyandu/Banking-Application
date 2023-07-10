import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './page/main/main.component';
import { BrowserModule } from '@angular/platform-browser';
import { StaffLoginComponent } from './page/staff-login/staff-login.component';
import { StaffdashboardComponent } from './page/staffdashboard/staffdashboard.component';
import { StaffApproveAccountComponent } from './page/staff-approve-account/staff-approve-account.component';
import { StaffApproveBeneficiaryComponent } from './page/staff-approve-beneficiary/staff-approve-beneficiary.component';
import { StaffByAccountNumberComponent } from './page/staff-by-account-number/staff-by-account-number.component';
import { StaffEnableDisableCustomerComponent } from './page/staff-enable-disable-customer/staff-enable-disable-customer.component';
const routes: Routes = [
  {path:'main',component:MainComponent},
  {path:'staffLogin',component:StaffLoginComponent},
  {path:"staffDashboard",component:StaffdashboardComponent},
  {path:"staffApploveAccount",component:StaffApproveAccountComponent},
  {path:"staffApploveBeneficiary",component:StaffApproveBeneficiaryComponent},
  {path:"staffFindByAccountNumber",component:StaffByAccountNumberComponent},
  {path:"staffDisableOrEnableCustomer",component:StaffEnableDisableCustomerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
