import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent {
  token:any;
  newPassword:any;
  constructor(private router1:Router, private router: ActivatedRoute,private customerService:CustomerService){
    this.token=this.router.snapshot.paramMap.get("token");
    
  }
  reset(){
    this.customerService.savePassword(this.token,this.newPassword).subscribe(res=>{
      console.log(res);
      alert(res.message);
    })
  }
}
