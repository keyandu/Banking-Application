import { Component } from '@angular/core';
import { StaffServiceService } from '../staff-service/staff-service.service';

@Component({
  selector: 'app-staff-approve-account',
  templateUrl: './staff-approve-account.component.html',
  styleUrls: ['./staff-approve-account.component.css']
})
export class StaffApproveAccountComponent {
  accountList:any=[];
  constructor(
    private _staffService:StaffServiceService
  ){
    this._staffService.getAllAccountToBeApproved().subscribe(result=>{this.accountList=result})

  }
  approveOnClick(accNo:string){
    this._staffService.approveAccount(Number(accNo))
  }
}
