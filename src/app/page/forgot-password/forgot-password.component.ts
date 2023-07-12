import { Component } from '@angular/core';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent {
  email:string='';
  constructor(private customerService:CustomerService){

  }
  reset(){
    this.customerService.resetPassword(this.email).subscribe(res=>
      {
        console.log(res);
        
      })
  }
}
