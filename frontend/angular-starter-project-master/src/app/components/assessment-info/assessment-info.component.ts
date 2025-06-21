import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { FormserviceService } from 'src/app/services/formservice.service';

@Component({
  selector: 'app-assessment-info',
  templateUrl: './assessment-info.component.html',
  styleUrls: ['./assessment-info.component.css']
})
export class AssessmentInfoComponent {
  assessmentForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private formService: FormserviceService) {
    this.assessmentForm = this.fb.group({
      strength: ['', Validators.required],
      weaknesse: ['', Validators.required],
      shortTermGoal: ['', Validators.required],
      longTermGoal: ['', Validators.required],
      hobbie: ['', Validators.required],
    });
  }

  previous() {
    this.router.navigate(['/referee-info']);
  }

  next() {
    this.formService.savePartialData('assessmentForm', this.assessmentForm.value);
    this.router.navigate(['/qualification-info']);
  }
}