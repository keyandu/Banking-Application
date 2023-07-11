import { Component } from '@angular/core';
import { StaffServiceService } from '../staff-service/staff-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-staffdashboard',
  templateUrl: './staffdashboard.component.html',
  styleUrls: ['./staffdashboard.component.css']
})
export class StaffdashboardComponent {
  username =localStorage.getItem('staffUsername');
  logined:boolean=this.staffService.logined;
  constructor(
  private staffService: StaffServiceService,
  private router: Router  ){

  }
  logoutHandler(){
    this.staffService.logout();
    window.location.reload();
    //this.router.navigate(['/staffLogin'])
  }
}
