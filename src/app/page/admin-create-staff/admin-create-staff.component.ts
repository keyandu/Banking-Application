import { Component } from '@angular/core';
import { AdminServiceService } from '../admin-service/admin-service.service';

@Component({
  selector: 'app-admin-create-staff',
  templateUrl: './admin-create-staff.component.html',
  styleUrls: ['./admin-create-staff.component.css']
})
export class AdminCreateStaffComponent {
  fullname:string='';
  username:string='';
  email:string='';
  password:string='';
  constructor(private adminService: AdminServiceService,){

  }
  create(){
    this.adminService.createStaff(this.fullname,this.username,this.email,this.password)
    .subscribe(result=>{
      console.log(result);
      this.email='';
      this.fullname='';
      this.password='';
      this.username='';
    });
  }
}
