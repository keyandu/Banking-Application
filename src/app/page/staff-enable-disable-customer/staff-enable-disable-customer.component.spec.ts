import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StaffEnableDisableCustomerComponent } from './staff-enable-disable-customer.component';

describe('StaffEnableDisableCustomerComponent', () => {
  let component: StaffEnableDisableCustomerComponent;
  let fixture: ComponentFixture<StaffEnableDisableCustomerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StaffEnableDisableCustomerComponent]
    });
    fixture = TestBed.createComponent(StaffEnableDisableCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
