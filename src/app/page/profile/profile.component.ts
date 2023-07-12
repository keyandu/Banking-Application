import { Component } from '@angular/core';
import { User } from 'src/app/model/User';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
  userId = Number(localStorage.getItem("customerId"))
  
  user:any = new User();
  constructor(private _service:CustomerService){
    this._service.getUserDetail(this.userId).subscribe(res=>{
      this.user=res;
    })
  }


  saveChange():void{
    this._service.saveChange(this.user.email,this.user.mobileNo,this.user.address).subscribe(res=>{
      console.log(res);
      this._service.getUserDetail(this.userId).subscribe(res=>{this.user.res});
    })
  }
}
