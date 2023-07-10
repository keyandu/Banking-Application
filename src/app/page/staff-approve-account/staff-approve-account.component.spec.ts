import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StaffApproveAccountComponent } from './staff-approve-account.component';

describe('StaffApproveAccountComponent', () => {
  let component: StaffApproveAccountComponent;
  let fixture: ComponentFixture<StaffApproveAccountComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StaffApproveAccountComponent]
    });
    fixture = TestBed.createComponent(StaffApproveAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
