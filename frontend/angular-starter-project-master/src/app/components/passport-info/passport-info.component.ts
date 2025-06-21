import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { FormserviceService } from 'src/app/services/formservice.service';

@Component({
  selector: 'app-passport-info',
  templateUrl: './passport-info.component.html',
  styleUrls: ['./passport-info.component.css']
})
export class PassportInfoComponent {
  passportForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private formService: FormserviceService) {
    this.passportForm = this.fb.group({
      passportNumber: [''],
      dateOfIssue: [''],
      dateOfExpiry: [''],
      placeOfIssue: [''],
    });
  }

  previous() {
    this.router.navigate(['/family-info']);
  }

  next() {
    this.formService.savePartialData('passportForm', this.passportForm.value);
    this.router.navigate(['/language-info']);
  }
}