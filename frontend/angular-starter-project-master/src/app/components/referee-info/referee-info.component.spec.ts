import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RefereeInfoComponent } from './referee-info.component';

describe('RefereeInfoComponent', () => {
  let component: RefereeInfoComponent;
  let fixture: ComponentFixture<RefereeInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RefereeInfoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RefereeInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
