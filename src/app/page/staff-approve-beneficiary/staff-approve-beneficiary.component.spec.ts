import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StaffApproveBeneficiaryComponent } from './staff-approve-beneficiary.component';

describe('StaffApproveBeneficiaryComponent', () => {
  let component: StaffApproveBeneficiaryComponent;
  let fixture: ComponentFixture<StaffApproveBeneficiaryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StaffApproveBeneficiaryComponent]
    });
    fixture = TestBed.createComponent(StaffApproveBeneficiaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
