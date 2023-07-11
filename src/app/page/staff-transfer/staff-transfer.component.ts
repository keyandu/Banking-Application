import { Component } from '@angular/core';

@Component({
  selector: 'app-staff-transfer',
  templateUrl: './staff-transfer.component.html',
  styleUrls: ['./staff-transfer.component.css']
})
export class StaffTransferComponent {
  fromAccount!:number;
  toAccount!:number;
  amount!:number;
  remarks!:string;
  constructor(){

  }
  transfer(){
    
  }
}
