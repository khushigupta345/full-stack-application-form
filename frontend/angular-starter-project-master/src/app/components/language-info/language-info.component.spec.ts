import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LanguageInfoComponent } from './language-info.component';

describe('LanguageInfoComponent', () => {
  let component: LanguageInfoComponent;
  let fixture: ComponentFixture<LanguageInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LanguageInfoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LanguageInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
