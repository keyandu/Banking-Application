import { Component,OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { StaffServiceService } from '../staff-service/staff-service.service';
import { AlertServiceService } from '../alert-service/alert-service.service';


@Component({
  selector: 'app-staff-login',
  templateUrl: './staff-login.component.html',
  styleUrls: ['./staff-login.component.css']
})
export class StaffLoginComponent implements OnInit {
  form!: FormGroup;
  loading=false;
  submitted=false;
  logined:boolean=this.staffService.logined;
  username =localStorage.getItem('staffUsername');

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private staffService: StaffServiceService,
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
    }, 3000);
}


  onSubmit(){
    this.submitted=true;

    if(this.form.invalid){
      return;
    }
    this.loading=true;
    this.staffService.staffLogin(this.f['username'].value, this.f['password'].value)
      .pipe(first())
      .subscribe(resp=>{
        localStorage.setItem("staff-logined",'true')
        this.username=localStorage.getItem('staffUsername');
      })
      //this.reloadPage();

    
  }
}
