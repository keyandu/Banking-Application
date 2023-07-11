import { Component } from '@angular/core';
import { NgModel } from '@angular/forms';
import { StaffServiceService } from '../staff-service/staff-service.service';
import { AccountStatment } from '../model/AccountStatement';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-staff-by-account-number',
  templateUrl: './staff-by-account-number.component.html',
  styleUrls: ['./staff-by-account-number.component.css']
})
export class StaffByAccountNumberComponent {
  accountNumber:number=0;
  accountStatment:AccountStatment=new AccountStatment();
  showDetail:boolean=false;
  constructor(
    private staffService: StaffServiceService,
  ){

  }
  goOnClick(){
    
    this.staffService.getAccountById(this.accountNumber).subscribe(result=>{
      this.accountStatment=result;
      console.log(result);
    },error=>{
      this.showDetail=false;
      console.log(error);
    });
    if(this.accountStatment.accountType!=''){
      this.showDetail=true;
      
    }else{
      this.showDetail=false;
    }
    console.log(this.showDetail);
  }
}
