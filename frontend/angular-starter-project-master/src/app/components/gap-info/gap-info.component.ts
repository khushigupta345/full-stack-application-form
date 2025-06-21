import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { FormserviceService } from 'src/app/services/formservice.service';

@Component({
  selector: 'app-gap-info',
  templateUrl: './gap-info.component.html',
  styleUrls: ['./gap-info.component.css']
})
export class GapInfoComponent {
  gapForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private formService: FormserviceService) {
    this.gapForm = this.fb.group({
      gapExplanations: this.fb.array([this.createGapGroup()])
    });
  }

  get gapExplanations(): FormArray {
    return this.gapForm.get('gapExplanations') as FormArray;
  }

  createGapGroup(): FormGroup {
    return this.fb.group({
      fromDate: [''],
      toDate: [''],
      reason: [''],
      
    });
  }

  addGap() {
    if (this.gapExplanations.length < 3) {
      this.gapExplanations.push(this.createGapGroup());
    }
  }

  removeGap(index: number) {
    if (this.gapExplanations.length > 1) {
      this.gapExplanations.removeAt(index);
    }
  }

  previous() {
    this.router.navigate(['/qualification-info']);
  }

  submit() {
    this.formService.savePartialData('gapForm', this.gapForm.value);
       this.router.navigate(['/declaration-info']);
    console.log('All Form Data:', this.formService.getFormData());

    
  }
}