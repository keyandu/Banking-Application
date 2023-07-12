import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AddAcct } from 'src/app/model/AddAcct';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-create-acct',
  templateUrl: './create-acct.component.html',
  styleUrls: ['./create-acct.component.css']
})
export class CreateAcctComponent {
  acct = new AddAcct();
  userId = Number(localStorage.getItem("customerId"))
  constructor(private service:CustomerService, private router:Router){
    this.router.routeReuseStrategy.shouldReuseRoute = () => {
      return false;
    };
  }
  addAcct(){

    this.service.addAcct(this.userId,this.acct).subscribe(result =>{
      console.log(result)
    })
    this.router.navigateByUrl('');


  }
}
