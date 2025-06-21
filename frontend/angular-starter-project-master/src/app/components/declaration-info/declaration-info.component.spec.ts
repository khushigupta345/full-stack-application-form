import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeclarationInfoComponent } from './declaration-info.component';

describe('DeclarationInfoComponent', () => {
  let component: DeclarationInfoComponent;
  let fixture: ComponentFixture<DeclarationInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DeclarationInfoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DeclarationInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
