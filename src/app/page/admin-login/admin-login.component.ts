import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminServiceService } from '../admin-service/admin-service.service';
import { AlertServiceService } from '../alert-service/alert-service.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent {
  form!: FormGroup;
  loading=false;
  submitted=false;
  logined:boolean=this.adminService.logined;
  username =localStorage.getItem('adminUsername');
  
  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private adminService: AdminServiceService,
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
    this.adminService.adminLogin(this.f['username'].value, this.f['password'].value)
      .pipe(first())
      .subscribe(resp=>{
        localStorage.setItem("adminLogined",'true')
        this.username=localStorage.getItem('adminUsername');
      })
      this.reloadPage();

    
  }
  logout(){
    this.adminService.logout();
    this.reloadPage();
  }
}
