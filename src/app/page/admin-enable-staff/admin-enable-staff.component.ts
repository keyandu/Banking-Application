import { Component } from '@angular/core';
import { AdminServiceService } from '../admin-service/admin-service.service';

@Component({
  selector: 'app-admin-enable-staff',
  templateUrl: './admin-enable-staff.component.html',
  styleUrls: ['./admin-enable-staff.component.css']
})
export class AdminEnableStaffComponent {
  customerList: any=[];
  constructor(private adminService:AdminServiceService){
    this.adminService.listAllStaff().subscribe(result=>{
      this.customerList=result;
    })

  }
  EnableOrDisableOnClick(id:number,status:string){
      const status1=(status=='Enable')?'Disable':'Enable';
      this.adminService.changeStaffStatus(id,status1).subscribe(
        result=>{
          console.log(result);
        }
      );
      this.adminService.listAllStaff().subscribe(result=>{
        this.customerList=result;
      });
  }
}
