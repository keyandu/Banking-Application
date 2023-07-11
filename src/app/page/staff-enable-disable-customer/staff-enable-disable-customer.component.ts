import { Component } from '@angular/core';
import { StaffServiceService } from '../staff-service/staff-service.service';

@Component({
  selector: 'app-staff-enable-disable-customer',
  templateUrl: './staff-enable-disable-customer.component.html',
  styleUrls: ['./staff-enable-disable-customer.component.css']
})
export class StaffEnableDisableCustomerComponent {
  customerList: any=[];
  constructor(private staffService:StaffServiceService){
    this.staffService.listAllCustomer().subscribe(result=>{
      this.customerList=result;
    })

  }
  EnableOrDisableOnClick(id:number,status:string){
      const status1=(status=='Enable')?'Disable':'Enable';
      this.staffService.changeCustomerStatus(id,status1).subscribe(
        result=>{
          console.log(result);
        }
      );
      this.staffService.listAllCustomer().subscribe(result=>{
        this.customerList=result;
      });
  }

}
