import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssessmentInfoComponent } from './assessment-info.component';

describe('AssessmentInfoComponent', () => {
  let component: AssessmentInfoComponent;
  let fixture: ComponentFixture<AssessmentInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AssessmentInfoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AssessmentInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
