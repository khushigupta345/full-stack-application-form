import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { FormserviceService } from 'src/app/services/formservice.service';

@Component({
  selector: 'app-qualification-info',
  templateUrl: './qualification-info.component.html',
  styleUrls: ['./qualification-info.component.css']
})
export class QualificationInfoComponent {
  qualificationForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private formService: FormserviceService) {
    this.qualificationForm = this.fb.group({
      additionalQualifications: this.fb.array([this.createQualificationGroup()])
    });
  }

  get additionalQualifications(): FormArray {
    return this.qualificationForm.get('additionalQualifications') as FormArray;
  }

  createQualificationGroup(): FormGroup {
    return this.fb.group({
      program: [''],
      institute: [''],
      fromDate: [''],
      toDate: [''],
      percentage: [''],
      division: ['']
    });
  }

  addQualification() {
    this.additionalQualifications.push(this.createQualificationGroup());
  }

  removeQualification(index: number) {
    if (this.additionalQualifications.length > 1) {
      this.additionalQualifications.removeAt(index);
    }
  }

  previous() {
    this.router.navigate(['/assessment-info']);
  }

  next() {
    this.formService.savePartialData('qualificationForm', this.qualificationForm.value);
    this.router.navigate(['/gap-info']);
  }
}