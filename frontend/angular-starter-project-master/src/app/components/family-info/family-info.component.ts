import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { FormserviceService } from 'src/app/services/formservice.service';

@Component({
  selector: 'app-family-info',
  templateUrl: './family-info.component.html',
  styleUrls: ['./family-info.component.css']
})
export class FamilyInfoComponent {
  familyForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private formService: FormserviceService) {
    this.familyForm = this.fb.group({
      familyMembers: this.fb.array([this.createMemberGroup()])
    });
  }

  get familyMembers(): FormArray {
    return this.familyForm.get('familyMembers') as FormArray;
  }

  createMemberGroup(): FormGroup {
    return this.fb.group({
      name: ['', Validators.required],
      relationship: ['', Validators.required],

    });
  }

  addMember() {
    this.familyMembers.push(this.createMemberGroup());
  }

  removeMember(index: number) {
    if (this.familyMembers.length > 1) {
      this.familyMembers.removeAt(index);
    }
  }

  previous() {
    this.router.navigate(['/education-info']);
  }

  next() {
    this.formService.savePartialData('familyForm', this.familyForm.value);
    this.router.navigate(['/passport-info']);
  }
}