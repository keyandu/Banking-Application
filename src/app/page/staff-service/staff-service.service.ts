import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import{Observable} from 'rxjs';
import { environment } from '../model/environment';

@Injectable({
  providedIn: 'root'
})
export class StaffServiceService {

  constructor(private http : HttpClient) { }
  public staffLogin(username:string,password:string):Observable<String>{
      return this.http.post(
        environment.staffLoginUrl,
        {
          username:username,
          password:password,

        }, 
        { responseType: 'text' }
      );
  }
  
}
