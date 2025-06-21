import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AchievementInfoComponent } from './achievement-info.component';

describe('AchievementInfoComponent', () => {
  let component: AchievementInfoComponent;
  let fixture: ComponentFixture<AchievementInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AchievementInfoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AchievementInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
