import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Account } from '../model/Account';
import { Beneficiary } from '../model/Beneficiary';
import {AddAcct} from '../model/AddAcct';
import { AddBene } from '../model/AddBene';
import { DeActivate } from '../model/DeActivate';
import { User } from '../model/User';
import { JwtTokenResponse } from '../page/model/JwtTokenResponse';
import * as moment from 'moment';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  acctId:number=0;
  logined=(localStorage.getItem('customerLogined')=='true');
  user_Id=Number(localStorage.getItem('customerId'));
  constructor(private http: HttpClient) { 
    
  }
  customerLogin(username:string,password:string):Observable<JwtTokenResponse>{
  
    return  this.http.post<JwtTokenResponse>(
        "http://localhost:8085/api/customer/authenticate",
        {
          username,
          password
        }
      ).pipe(map(response=>{
        if(response.accessToken!=''){
          localStorage.setItem("customerToken",response.accessToken);
          localStorage.setItem("customerId",response.id.toString());
          localStorage.setItem("customerUsername",response.username);
          localStorage.setItem("customerEmail",response.email);
          localStorage.setItem("customerType",response.type);
          localStorage.setItem("customerExpires_at", moment().add(1,'day').valueOf.toString() );
          this.logined=(localStorage.getItem("customerLogined")=='true');
        }
        return response;
      }));
  }

         

logout() {
  localStorage.removeItem("customerToken");
  localStorage.removeItem("customerId");
  localStorage.removeItem("customerUsername");
  localStorage.removeItem("customerEmail");
  localStorage.removeItem("customerType");
  localStorage.removeItem("customerExpires_at");
  localStorage.removeItem("customerLogined")
}
createCustomer(username:string,fullname:string,
  email:string,password:string):Observable<any>{
  return this.http.post<string>("http://localhost:8085/api/register", { username, fullname, email, password,"role":["customer"] });
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
  saveChange(email:string,mobileNo:number,address:string):Observable<any>{
    var headers = new HttpHeaders({
      "Content-Type": "application/json",
      "Accept": "application/json"
  });
    return this.http.put("http://localhost:8085/api/customer/update/"+this.user_Id,{
      email,mobileNo,address
    },{headers:headers});
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
  resetPassword(email:string):Observable<any>{
    var headers = new HttpHeaders({
      "Content-Type": "application/json",
      "Accept": "application/json"
  });
    return this.http.post("http://localhost:8085/api/user/resetPassword/"+email,{headers:headers});
  }
  savePassword(token:string,newPassword:string):Observable<any>{
    var headers = new HttpHeaders({
      "Content-Type": "application/json",
      "Accept": "application/json"
  });
    return this.http.post("http://localhost:8085/api/user/savePassword/",{token,newPassword},{headers:headers});
  }
}
