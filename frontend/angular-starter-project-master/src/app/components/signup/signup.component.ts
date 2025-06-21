
import { Component } from '@angular/core'; import { FormBuilder, FormGroup, Validators } from '@angular/forms'; import { AuthService } from 'src/app/services/auth.service'; import { Router } from '@angular/router'; import { FormserviceService } from 'src/app/services/formservice.service';

@Component({ selector: 'app-signup', templateUrl: './signup.component.html', styleUrls: ['./signup.component.css'] }) export class SignupComponent { signupForm: FormGroup; submitting = false;

constructor( private fb: FormBuilder, private auth: AuthService, private router: Router, private formService: FormserviceService ) { this.signupForm = this.fb.group({ name: ['', Validators.required], email: ['', [Validators.required, Validators.email]], password: ['', Validators.required] }); }

submit() {
  if (this.signupForm.invalid) return;
  this.submitting = true;

  this.auth.signup(this.signupForm.value).subscribe({
    next: (res) => {
      this.submitting = false;

      if (res.token) {
        this.auth.saveToken(res.token);

        Promise.resolve().then(()=>{
          this.checkFormStatus()
        });
       
      }
    },
    error: (err) => {
      this.submitting = false;
      const message = err.error?.message || 'Signup failed';

      alert(message);

      if (message.toLowerCase().includes('form already')) {
        setTimeout(() => this.checkFormStatus(), 100);
      }
    }
  });
}
private checkFormStatus() {
  this.formService.getMyForm().subscribe({
    next: (data) => {
      if (!data.formSubmitted) {
        this.router.navigate(['/personal-info']);
      } else if (data.formSubmitted && data.formUpdated) {
        this.router.navigate(['/review-submit'], { queryParams: { readonly: 'true' } });
      } else if (data.formSubmitted && !data.formUpdated) {
        this.router.navigate(['/review-submit']);
      }
    },
    error: (err) => {
      if (err.status === 401) {
        
        this.auth.logout();
        
      } else {
        const message = typeof err.error === 'string'
          ? err.error
          : err.error?.message || 'Something went wrong while loading your form.';
        alert(message);
        console.log(message)
      }
    }
  });
}
}