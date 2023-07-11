import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StaffTransferComponent } from './staff-transfer.component';

describe('StaffTransferComponent', () => {
  let component: StaffTransferComponent;
  let fixture: ComponentFixture<StaffTransferComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StaffTransferComponent]
    });
    fixture = TestBed.createComponent(StaffTransferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
