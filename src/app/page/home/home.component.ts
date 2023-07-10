import { Component } from '@angular/core';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  acctList:any = []
  beneList:any = []

  constructor(private _customerService: CustomerService){
    this._customerService.getAccountsByCustomer(2).subscribe(result =>{
      this.acctList=result;
    })
    
    this._customerService.getBeneficiary(2).subscribe(
      result=>{
        this.beneList=result;
      }
    )
  }
  OnClick(id:number):void{
    this._customerService.setAcctId(id);
  }
}