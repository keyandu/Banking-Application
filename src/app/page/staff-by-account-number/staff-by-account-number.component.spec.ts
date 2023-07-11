import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StaffByAccountNumberComponent } from './staff-by-account-number.component';

describe('StaffByAccountNumberComponent', () => {
  let component: StaffByAccountNumberComponent;
  let fixture: ComponentFixture<StaffByAccountNumberComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StaffByAccountNumberComponent]
    });
    fixture = TestBed.createComponent(StaffByAccountNumberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
