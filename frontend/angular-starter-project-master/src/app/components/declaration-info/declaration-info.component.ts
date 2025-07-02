
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FormserviceService } from 'src/app/services/formservice.service';

@Component({
  selector: 'app-declaration-info',
  templateUrl: './declaration-info.component.html',
  styleUrls: ['./declaration-info.component.css']
})
export class DeclarationInfoComponent implements OnInit {
  declarationForm: FormGroup;
  submitting = false;
  errorMessage = '';

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private formService: FormserviceService
  ) {
    this.declarationForm = this.fb.group({
      declarationSignedBy: ['', Validators.required],
      declarationDate: [new Date().toISOString().substring(0, 10), Validators.required]
    });
  }

  ngOnInit(): void {
    // Load saved data if available
    const saved = this.formService.getSectionData('declarationForm');
    if (saved) {
      this.declarationForm.patchValue(saved);
    }
  }

  previous(): void {
    this.router.navigate(['/gap-info']);
  }

  submit(): void {
    if (this.declarationForm.invalid) return;

    this.submitting = true;
    this.errorMessage = '';

    this.formService.savePartialData('declarationForm', this.declarationForm.value);

    this.formService.submitForm().subscribe({
      next: (res) => {
        console.log("jjjjjjjjjj",this.declarationForm.value)
        this.submitting = false;

        if (res?.message === 'Form submitted successfully.') {
          this.formService.setSubmitted(); 
          this.formService.clearFormData(); 

          this.router.navigate(['/review-submit']); 
        } else 
        if (res?.message === 'Form already submitted.') {
          this.formService.setSubmitted(); 
          this.formService.clearFormData(); 

          this.router.navigate(['/review-submit']); 
        } 
        else {
          const msg = res?.message || 'Unexpected response from server.';
          this.errorMessage = msg;
          alert(this.errorMessage); 
        }
      },
      error: (err) => {
        this.submitting = false;
        const msg = typeof err.error === 'string'
          ? err.error
          : err.error?.message || 'Submission failed. Please try again.';
        this.errorMessage = msg;
        alert(this.errorMessage);
      }
    });
  }
}