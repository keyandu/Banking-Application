import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Account } from '../model/Account';
import { Beneficiary } from '../model/Beneficiary';
import {AddAcct} from '../model/AddAcct';
import { AddBene } from '../model/AddBene';
import { DeActivate } from '../model/DeActivate';
import { User } from '../model/User';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  acctId:number=0;
  constructor(private http: HttpClient) { 

  }
  getAccountsByCustomer(userId:number):Observable<Account[]>{
    return this.http.get<Account[]>("http://localhost:8085/api/customer/"+userId+"/get_accounts")
  }
  getAccountsDetail(id:number):Observable<Account>{
    return this.http.get<Account>("http://localhost:8085/api/customer/account_details/"+id)
  }
  getBeneficiary(userId:number):Observable<Beneficiary[]>{
    return this.http.get<Beneficiary[]>("http://localhost:8085/api/customer/"+userId+"/get_beneficiary")
  }
  addAcct(userId:number,addAcct:AddAcct):Observable<any>{
    var headers = new HttpHeaders({
      "Content-Type": "application/json",
      "Accept": "application/json"
  });
  
    return this.http.post("http://localhost:8085/api/customer/"+userId+"/create_account",JSON.stringify(addAcct),{headers:headers})
  }
  addBene(userId:number,bene:AddBene):Observable<any>{
    var headers = new HttpHeaders({
      "Content-Type": "application/json",
      "Accept": "application/json"
  });
    return this.http.post("http://localhost:8085/api/customer/"+userId+"/add_beneficiary",JSON.stringify(bene),{headers:headers})
  }
  deactivateBene(bid:number, bene:DeActivate):Observable<any>{
    var headers = new HttpHeaders({
      "Content-Type": "application/json",
      "Accept": "application/json"
  });
    return this.http.put("http://localhost:8085/api/customer/deactive_bene/"+bid,JSON.stringify(bene),{headers:headers});
  }

  setAcctId(id:number):void{
    this.acctId = id;
  }
  getAccId():number{
    return this.acctId;
  }
  getUserDetail(userid:number):Observable<any>{
    return this.http.get<User[]>("http://localhost:8085/api/customer/getCustomer/"+userid)

  }
}
