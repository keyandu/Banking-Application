import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './page/main/main.component';
import { CreateAcctComponent } from './page/create-acct/create-acct.component';
import { AddBeneficiaryComponent } from './page/add-beneficiary/add-beneficiary.component';
import { HomeComponent } from './page/home/home.component';
import { StatementComponent } from './page/statement/statement.component';
import { ProfileComponent } from './page/profile/profile.component';


const routes: Routes = [
  {path:'dashboard',component:MainComponent},
  {path:'create_account',component:CreateAcctComponent},
  {path:'add_beneficary',component:AddBeneficiaryComponent},
  {path:'home',component:HomeComponent},
  {path:'statement',component:StatementComponent},
  {path:'profile',component:ProfileComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
