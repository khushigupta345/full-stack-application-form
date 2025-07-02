import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { FormserviceService } from 'src/app/services/formservice.service';

@Component({
  selector: 'app-referee-info',
  templateUrl: './referee-info.component.html',
  styleUrls: ['./referee-info.component.css']
})
export class RefereeInfoComponent {
  refereeForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private formService: FormserviceService) {
    this.refereeForm = this.fb.group({
      referees: this.fb.array([this.createRefereeGroup()])
    });
  }
  ngOnInit(): void {
    // Load saved data if available
    const saved = this.formService.getSectionData('refereeForm');
    if (saved) {
      this.refereeForm.patchValue(saved);
    }
  }

  get referees(): FormArray {
    return this.refereeForm.get('referees') as FormArray;
  }

  createRefereeGroup(): FormGroup {
    return this.fb.group({
      name: ['', Validators.required],
      designation: ['', Validators.required],
      company: [''],
      contact: ['', Validators.required],
  
    });
  }

  addReferee() {
    if (this.referees.length < 2) {
      this.referees.push(this.createRefereeGroup());
    }
  }

  removeReferee(index: number) {
    if (this.referees.length > 1) {
      this.referees.removeAt(index);
    }
  }

  previous() {
    this.router.navigate(['/employment-info']);
  }

  next() {
    this.formService.savePartialData('refereeForm', this.refereeForm.value);
    this.router.navigate(['/assessment-info']);
  }
}