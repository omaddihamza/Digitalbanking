import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupThanksComponent } from './signup-thanks.component';

describe('SignupThanksComponent', () => {
  let component: SignupThanksComponent;
  let fixture: ComponentFixture<SignupThanksComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SignupThanksComponent]
    });
    fixture = TestBed.createComponent(SignupThanksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
