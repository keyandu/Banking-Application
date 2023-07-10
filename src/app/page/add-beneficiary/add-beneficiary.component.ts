import { Component } from '@angular/core';
import { AddBene } from 'src/app/model/AddBene';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-add-beneficiary',
  templateUrl: './add-beneficiary.component.html',
  styleUrls: ['./add-beneficiary.component.css']
})
export class AddBeneficiaryComponent {
  beneficiary:AddBene = new AddBene();
  new_account_number:string="";
  errMes:boolean = false;
  constructor(private service:CustomerService){

  }

  addBene(userId:number){

    if(this.new_account_number===this.beneficiary.accountNo){
      this.service.addBene(userId,this.beneficiary).subscribe(result =>{
        console.log(result)
      })
    }
    else{
      this.errMes = true;
    }
    
  }
}
