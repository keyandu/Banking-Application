import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAcctComponent } from './create-acct.component';

describe('CreateAcctComponent', () => {
  let component: CreateAcctComponent;
  let fixture: ComponentFixture<CreateAcctComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateAcctComponent]
    });
    fixture = TestBed.createComponent(CreateAcctComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
