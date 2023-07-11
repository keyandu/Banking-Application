import { Component } from '@angular/core';
import { StaffServiceService } from '../staff-service/staff-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-staffdashboard',
  templateUrl: './staffdashboard.component.html',
  styleUrls: ['./staffdashboard.component.css']
})
export class StaffdashboardComponent {
  username =localStorage.getItem('staffUsername');
  accountList:any=[];
  constructor(
    private staffService:StaffServiceService,private router: Router 
  ){
    this.staffService.listAllAccounts().subscribe(result=>{this.accountList=result})

  }
  approveOnClick(accNo:string){
    this.staffService.approveAccount(accNo);
    console.log(accNo)
    this.refresh();
  }
  refresh(){
    this.staffService.getAllAccountToBeApproved().subscribe(result=>{this.accountList=result})

  }
  
  logoutHandler(){
    this.staffService.logout();
    //this.router.navigate(['/staffLogin'])
  }
}
