import { Component } from '@angular/core';
import { StaffServiceService } from '../staff-service/staff-service.service';
import { Alert } from '../model/Alert';

@Component({
  selector: 'app-staff-transfer',
  templateUrl: './staff-transfer.component.html',
  styleUrls: ['./staff-transfer.component.css']
})
export class StaffTransferComponent {
  fromAccount!:string;
  toAccount!:string;
  amount!:number;
  remarks!:string;
  constructor(private staffservice:StaffServiceService){

  }
  transfer(){
    if(this.amount<=0){
      alert("amount can not less than 0");
      return;
    }
    this.staffservice.transfer(this.fromAccount,this.toAccount,this.amount,this.remarks).subscribe(result=>{
      this.fromAccount='';
      this.toAccount='';
      this.amount=0;
      this.remarks='';
      alert("transfer success");
    })
  }
}
