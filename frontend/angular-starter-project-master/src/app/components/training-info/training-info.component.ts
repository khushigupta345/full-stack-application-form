import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { FormserviceService } from 'src/app/services/formservice.service';

@Component({
  selector: 'app-training-info',
  templateUrl: './training-info.component.html',
  styleUrls: ['./training-info.component.css']
})
export class TrainingInfoComponent {
  trainingForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private formService: FormserviceService) {
    this.trainingForm = this.fb.group({
      trainings: this.fb.array([this.createTrainingGroup()])
    });
  }

  get trainings(): FormArray {
    return this.trainingForm.get('trainings') as FormArray;
  }

  createTrainingGroup(): FormGroup {
    return this.fb.group({
      seminarName: ['', Validators.required],
    institution: ['', Validators.required],
      conductedBy:  ['', Validators.required],
      fromDate:  ['', Validators.required],
      toDate:  ['', Validators.required],
    });
  }

  addTraining() {
    this.trainings.push(this.createTrainingGroup());
  }

  removeTraining(index: number) {
    if (this.trainings.length > 1) {
      this.trainings.removeAt(index);
    }
  }

  previous() {
    this.router.navigate(['/language-info']);
  }

  next() {
    this.formService.savePartialData('trainingForm', this.trainingForm.value);
    this.router.navigate(['/achievement-info']);
  }
}