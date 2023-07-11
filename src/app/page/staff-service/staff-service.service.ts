import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import{Observable, map} from 'rxjs';
import { environment } from '../model/environment';
import * as moment from "moment";
import { JwtTokenResponse } from '../model/JwtTokenResponse';
import { LoginRequest } from '../model/LoginRequest';
import { AccountStatment } from '../model/AccountStatement';
import { AccountInformation } from '../model/AccountInformation';


@Injectable({
  providedIn: 'root'
})
export class StaffServiceService {
  loginRequest:LoginRequest=new LoginRequest();
  constructor(private http : HttpClient) { }
 
  public staffLogin(username:string,password:string):Observable<JwtTokenResponse>{
   this.loginRequest.username=username;
   this.loginRequest.password=password;
    return  this.http.post<JwtTokenResponse>(
        environment.staffLoginUrl,
        this.loginRequest
      ).pipe(map(response=>{
        if(response.token!=''){
          localStorage.setItem("staffToken",response.token);
          localStorage.setItem("staffUsername",response.username);
          localStorage.setItem("staffEmail",response.email);
          localStorage.setItem("staffType",response.type);
          localStorage.setItem("expires_at", moment().add(1,'day').valueOf.toString() );
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
approveAccount(id:number){

  return this.http.put(environment.approveAccount,{id:id,approveOrNot:'Approve'})
}
}
