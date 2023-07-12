import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from 'src/app/service/customer.service';
import { AlertServiceService } from '../alert-service/alert-service.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent implements OnInit {
  form!: FormGroup;
  loading=false;
  submitted=false;
  logined:boolean=this.customerService.logined;
  username =localStorage.getItem('customerUsername');
  userid = localStorage.getItem('customerId')
  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private customerService: CustomerService,
    private alertService: AlertServiceService
      ){

  }
  ngOnInit(): void {
   this.form=this.formBuilder.group(
    {
      username: ['',Validators.required],
      password: ['',Validators.required]
    }
   );
  }

  get f(){
    return this.form.controls;
  }
  reloadPage() {
    setTimeout(()=>{
      window.location.reload();
    }, 1000);
}


  onSubmit(){
    this.submitted=true;

    if(this.form.invalid){
      return;
    }
    this.loading=true;
    this.customerService.customerLogin(this.f['username'].value, this.f['password'].value)
      .pipe(first())
      .subscribe(resp=>{
        localStorage.setItem("customerLogined",'true')
        this.username=localStorage.getItem('customerUsername');
        this.userid=localStorage.getItem('customerId');
      })
      this.reloadPage();

    
  }
}
