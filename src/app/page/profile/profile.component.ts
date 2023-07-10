import { Component } from '@angular/core';
import { User } from 'src/app/model/User';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
  user:any = new User();
  constructor(private _service:CustomerService){
    this._service.getUserDetail(2).subscribe(res=>{
      this.user=res;
    })
  }

}
