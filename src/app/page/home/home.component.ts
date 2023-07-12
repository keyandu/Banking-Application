import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnChanges {
  acctList:any = []
  beneList:any = []
  logined:boolean=this._customerService.logined;
  username =localStorage.getItem('customerUsername');
  userid = Number(localStorage.getItem('customerId'));
  constructor(private _customerService: CustomerService){
    this._customerService.getAccountsByCustomer(this.userid).subscribe(result =>{
      this.acctList=result;
    })
    
    this._customerService.getBeneficiary(this.userid).subscribe(
      result=>{
        this.beneList=result;
      }
    )
  }

  ngOnChanges(changes: SimpleChanges): void {
    this._customerService.getAccountsByCustomer(this.userid).subscribe(result =>{
      this.acctList=result;
    })
    
    this._customerService.getBeneficiary(this.userid).subscribe(
      result=>{
        this.beneList=result;
      }
    )
  }

  OnClick(id:number):void{
    this._customerService.setAcctId(id);
  }
  logoutHandler(){
    this._customerService.logout();
    window.location.reload();
    //this.router.navigate(['/staffLogin'])
  }
}