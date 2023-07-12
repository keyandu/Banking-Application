import { Injectable } from '@angular/core';
import * as moment from 'moment';
import { Observable, map } from 'rxjs';
import { JwtTokenResponse } from '../model/JwtTokenResponse';
import { environment } from '../model/environment';
import { HttpClient } from '@angular/common/http';
import { CustomerInformation } from '../model/CustomerInformation';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {
  logined=(localStorage.getItem('adminLogined')=='true');
  constructor(
    private http : HttpClient
  ) { }
  adminLogin(username:string,password:string):Observable<JwtTokenResponse>{
  
    return  this.http.post<JwtTokenResponse>(
        environment.adminLoginUrl,
        {
          username,
          password
        }
      ).pipe(map(response=>{
        if(response.accessToken!=''){
          localStorage.setItem("adminToken",response.accessToken);
          localStorage.setItem("adminUsername",response.username);
          localStorage.setItem("adminEmail",response.email);
          localStorage.setItem("adminType",response.type);
          localStorage.setItem("adminExpires_at", moment().add(1,'day').valueOf.toString() );
          this.logined=(localStorage.getItem("adminLogined")=='true');
        }
        return response;
      }));
  }

         

logout() {
  localStorage.removeItem("adminToken");
  localStorage.removeItem("adminUsername");
  localStorage.removeItem("adminEmail");
  localStorage.removeItem("adminType");
  localStorage.removeItem("adminExpires_at");
  localStorage.removeItem("adminLogined")
}

createStaff(staffFullName:string,staffUserName:string,
  email:string,staffPassword:string):Observable<string>{
  return this.http.post<string>(environment.createStaff, { staffFullName, staffUserName, email, staffPassword });
}
listAllStaff():Observable<CustomerInformation>{
  return this.http.get<CustomerInformation>(environment.listAllStaff)
}
changeStaffStatus(staffId:number,status:string){
  return this.http.put(environment.enableStaff,{staffId,status})
}
}
