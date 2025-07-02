import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { FormserviceService } from 'src/app/services/formservice.service';

@Component({
  selector: 'app-education-info',
  templateUrl: './education-info.component.html',
  styleUrls: ['./education-info.component.css']
})
export class EducationInfoComponent {
  educationForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private formService: FormserviceService) {
    this.educationForm = this.fb.group({
      educationList: this.fb.array([this.createEducationGroup()])
    });
  }
 ngOnInit(): void {
    // Load saved data if available
    const saved = this.formService.getSectionData('educationForm');
    if (saved) {
      this.educationForm.patchValue(saved);
    }
  }
  get educationList(): FormArray {
    return this.educationForm.get('educationList') as FormArray;
  }

  createEducationGroup(): FormGroup {
    return this.fb.group({
      degree: ['', Validators.required],
      course: ['', Validators.required],
      elective: [''],
      collegeName: ['', Validators.required],
      collegeAddress: ['', Validators.required],
      universityName: ['', Validators.required],
      universityAddress: ['', Validators.required],
      fromYear: ['', Validators.required],
      toYear: ['', Validators.required],
      percentage: ['', Validators.required],
    
    });
  }

  addEducation() {
    if (this.educationList.length < 4) {
      this.educationList.push(this.createEducationGroup());
    }
  }

  removeEducation(index: number) {
    if (this.educationList.length > 1) {
      this.educationList.removeAt(index);
    }
  }

  previous() {
    this.router.navigate(['/address-info']);
  }

  next() {
    this.formService.savePartialData('educationForm', this.educationForm.value);
    this.router.navigate(['/family-info']);
  }
}