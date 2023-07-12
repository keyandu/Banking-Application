import { Component } from '@angular/core';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {
  fullname:string='';
  username:string='';
  email:string='';
  password:string='';
  constructor(private customerService:CustomerService){

  }
  create(){
    this.customerService.createCustomer(this.username,this.fullname,this.email,this.password)
    .subscribe(result=>{
      console.log(result);
      this.email='';
      this.fullname='';
      this.password='';
      this.username='';
    });
}
}

