import { Component } from '@angular/core';
import { AddAcct } from 'src/app/model/AddAcct';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-create-acct',
  templateUrl: './create-acct.component.html',
  styleUrls: ['./create-acct.component.css']
})
export class CreateAcctComponent {
  acct = new AddAcct();

  constructor(private service:CustomerService){

  }
  addAcct(userId:number){

    this.service.addAcct(userId,this.acct).subscribe(result =>{
      console.log(result)
    })

  }
}
