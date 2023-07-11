import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import{Observable, map} from 'rxjs';
import { environment } from '../model/environment';
import * as moment from "moment";
import { JwtTokenResponse } from '../model/JwtTokenResponse';
import { LoginRequest } from '../model/LoginRequest';
import { AccountStatment } from '../model/AccountStatement';
import { AccountInformation } from '../model/AccountInformation';
import { CustomerInformation } from '../model/CustomerInformation';
import { BeneficiaryInformation } from '../model/BeneficiaryInformation';


@Injectable({
  providedIn: 'root'
})
export class StaffServiceService {
  loginRequest:LoginRequest=new LoginRequest();
  logined:boolean=(localStorage.getItem("staff-logined")=='true');
  constructor(private http : HttpClient) { }
 
  public staffLogin(username:string,password:string):Observable<JwtTokenResponse>{
  
    return  this.http.post<JwtTokenResponse>(
        environment.staffLoginUrl,
        {
          username,
          password
        }
      ).pipe(map(response=>{
        if(response.accessToken!=''){
          localStorage.setItem("staffToken",response.accessToken);
          localStorage.setItem("staffUsername",response.username);
          localStorage.setItem("staffEmail",response.email);
          localStorage.setItem("staffType",response.type);
          localStorage.setItem("expires_at", moment().add(1,'day').valueOf.toString() );
          this.logined=(localStorage.getItem("staff-logined")=='true');
        }
        return response;
      }));
  }

         

logout() {
  localStorage.removeItem("staffToken");
  localStorage.removeItem("staffUsername");
  localStorage.removeItem("staffEmail");
  localStorage.removeItem("staffType");
  localStorage.removeItem("expires_at");
  localStorage.removeItem("staff-logined")
}

public isLoggedIn() {
  if(localStorage.getItem("expires_at")==null){
    return false;
  }else{
    const expiration = localStorage.getItem("expires_at");
    const expiresAt = expiration!==null? expiration:"";
  
    return moment().valueOf()<=Number(expiresAt);
  }
}

isLoggedOut() {
    return !this.isLoggedIn();
}
getAccountById(id:number) :Observable<AccountStatment>{
  return this.http.get<AccountStatment>(environment.getCustomerStatement+'/'+id);
}  
getAllAccountToBeApproved():Observable<AccountInformation>{
  return this.http.get<AccountInformation>(environment.listAccountToBeApproved)
}
approveAccount(accNo:string){

  return this.http.put(environment.approveAccount,{accNo,approveOrNot:'Approve'}).
  subscribe(result=> {
    console.log(result);
  })
  
}
listAllAccounts():Observable<AccountInformation>{
  return this.http.get<AccountInformation>(environment.listAllAccount)
}
listAllCustomer():Observable<CustomerInformation>{
  return this.http.get<CustomerInformation>(environment.listAllCustomer)
}
changeCustomerStatus(customerId:number,status:string){
  return this.http.put(environment.EnableOrDisableCustomer,{customerId,status})
}
listBan():Observable<BeneficiaryInformation>{
  return this.http.get<BeneficiaryInformation>(environment.listBanToBeApproved)
}
approveBan(fromCustomer:number,beneficiaryAcNo:number,beneficiaryAddedDate:Date){
  console.log(beneficiaryAcNo)
  return this.http.put(environment.approveban,{fromCustomer,beneficiaryAcNo,beneficiaryAddedDate,approved:'YES'})
}
}
