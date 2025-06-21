import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { FormserviceService } from 'src/app/services/formservice.service';

@Component({
  selector: 'app-employment-info',
  templateUrl: './employment-info.component.html',
  styleUrls: ['./employment-info.component.css']
})
export class EmploymentInfoComponent {
  employmentForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private formService: FormserviceService) {
    this.employmentForm = this.fb.group({
      employmentHistories: this.fb.array([this.createEmploymentGroup()])
    });
  }

  get employmentHistories(): FormArray {
    return this.employmentForm.get('employmentHistories') as FormArray;
  }
trackByIndex(index: number): number {
  return index;
}
  createEmploymentGroup(): FormGroup {
    return this.fb.group({
      companyName: [''],
      designation: [''],
      location: [''],
      employmentFrom: [''],
      employmentTo: [''],
      hrName: [''],
      hrEmail: [''],
      hrContact: [''],
      reportingManager: [''],
      managerEmail: [''],
      ctc: [''],
      reasonForLeaving: ['']
    });
  }

  addEmployment() {
    if (this.employmentHistories.length < 3) {
      this.employmentHistories.push(this.createEmploymentGroup());
    }
  }

  removeEmployment(index: number) {
    if (this.employmentHistories.length > 1) {
      this.employmentHistories.removeAt(index);
    }
  }

  previous() {
    this.router.navigate(['/project-info']);
  }

  next() {
    this.formService.savePartialData('employmentForm', this.employmentForm.value);
    this.router.navigate(['/referee-info']);
  }
}