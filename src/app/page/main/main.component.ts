
import { Component } from '@angular/core';
import { Account } from 'src/app/model/Account';
import { DeActivate } from 'src/app/model/DeActivate';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
  accountList:any=[];
  beneList: any=[];
  acct:any = new Account();
  today:any = new Date();
  deActive:DeActivate = new DeActivate();
  constructor(private _customerService: CustomerService){
    this._customerService.getAccountsByCustomer(2).subscribe(result =>{
      this.accountList=result;
    })
    this._customerService.getBeneficiary(2).subscribe(
      result=>{
        this.beneList=result;
      }
    )
    this._customerService.getAccountsDetail(this._customerService.getAccId()).subscribe(res=>{
      this.acct=res;
    })
  }
  getAcctId(acctId:number):void{
    this._customerService.getAccountsDetail(acctId).subscribe(
      result=>{
        this.acct=result;
      }
    )
  }
  deactiveBene(bid:number):void{
    this.deActive.deactive = "NO";
    this._customerService.deactivateBene(bid,this.deActive).subscribe(
      res=>{
        console.log(res)
      }
    )
    this._customerService.getBeneficiary(2).subscribe(
      result=>{
        this.beneList=result;
      }
    )
  }

  
}
