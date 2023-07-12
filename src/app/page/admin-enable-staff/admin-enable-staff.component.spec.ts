import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminEnableStaffComponent } from './admin-enable-staff.component';

describe('AdminEnableStaffComponent', () => {
  let component: AdminEnableStaffComponent;
  let fixture: ComponentFixture<AdminEnableStaffComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminEnableStaffComponent]
    });
    fixture = TestBed.createComponent(AdminEnableStaffComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
