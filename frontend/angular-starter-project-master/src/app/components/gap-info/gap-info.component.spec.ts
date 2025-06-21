import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GapInfoComponent } from './gap-info.component';

describe('GapInfoComponent', () => {
  let component: GapInfoComponent;
  let fixture: ComponentFixture<GapInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GapInfoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GapInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
