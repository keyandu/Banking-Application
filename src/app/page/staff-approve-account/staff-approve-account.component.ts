import { Component, reflectComponentType } from '@angular/core';
import { StaffServiceService } from '../staff-service/staff-service.service';

@Component({
  selector: 'app-staff-approve-account',
  templateUrl: './staff-approve-account.component.html',
  styleUrls: ['./staff-approve-account.component.css']
})
export class StaffApproveAccountComponent {
  accountList:any=[];
  constructor(
    private staffService:StaffServiceService
  ){
    this.staffService.getAllAccountToBeApproved().subscribe(result=>{this.accountList=result})

  }
  approveOnClick(accNo:string){
    this.staffService.approveAccount(accNo);
    console.log(accNo)
    this.refresh();
  }
  refresh(){
    this.staffService.getAllAccountToBeApproved().subscribe(result=>{this.accountList=result})

  }
}
