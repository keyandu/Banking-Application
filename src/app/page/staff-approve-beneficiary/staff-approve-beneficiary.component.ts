import { Component } from '@angular/core';
import { StaffServiceService } from '../staff-service/staff-service.service';

@Component({
  selector: 'app-staff-approve-beneficiary',
  templateUrl: './staff-approve-beneficiary.component.html',
  styleUrls: ['./staff-approve-beneficiary.component.css']
})
export class StaffApproveBeneficiaryComponent {
  BeneficiaryList:any=[];
  constructor(
    private _staffService:StaffServiceService
  ){
    this._staffService.listBan().subscribe(result=>{this.BeneficiaryList=result})

  }
  approveOnClick(fromCustomer:number,accountNumber:number,addedDate:Date){
    this._staffService.approveBan(fromCustomer,accountNumber,addedDate).subscribe(result=>{
      console.log(result);
    });
    this._staffService.listBan().subscribe(result=>{this.BeneficiaryList=result});
  }
}
