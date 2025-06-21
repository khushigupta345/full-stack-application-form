import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassportInfoComponent } from './passport-info.component';

describe('PassportInfoComponent', () => {
  let component: PassportInfoComponent;
  let fixture: ComponentFixture<PassportInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PassportInfoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PassportInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
