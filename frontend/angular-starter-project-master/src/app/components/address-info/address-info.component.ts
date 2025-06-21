import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { FormserviceService } from 'src/app/services/formservice.service';

@Component({
selector: 'app-address-info',
templateUrl: './address-info.component.html',
styleUrls: ['./address-info.component.css']
})
export class AddressInfoComponent implements OnInit {
addressForm: FormGroup;
fromReview = false;

constructor(
private fb: FormBuilder,
private router: Router,
private route: ActivatedRoute,
private formService: FormserviceService
) {
this.addressForm = this.fb.group({
presentAddress: this.fb.group({
houseNo: ['', Validators.required],
city: ['', Validators.required],
state: ['', Validators.required],
pinCode: ['', [Validators.required, Validators.pattern(/^\d{6}$/)]],
country: ['', Validators.required]
}),
permanentAddress: this.fb.group({
houseNo: ['', Validators.required],
city: ['', Validators.required],
state: ['', Validators.required],
pinCode: ['', [Validators.required, Validators.pattern(/^\d{6}$/)]],
country: ['', Validators.required]
})
});
}

ngOnInit(): void {
this.route.queryParams.subscribe(params => {
this.fromReview = params['from'] === 'review';

//  Determine source of data
let data: any = {};
if (this.fromReview) {
// review‑flow: pulled from a temp store on the service
data = this.formService.getTempFormData() || {};
console.log('Address data from review flow:', data);
} else {

data = this.formService.getSectionData('addressForm') || {};
console.log('Address data from localStorage:', data);
}


this.addressForm.patchValue({
presentAddress: data.presentAddress || {},
permanentAddress: data.permanentAddress || {}
});
console.log('Prefilled addressForm:', this.addressForm.value);
});

}

copyAddress(e: any): void {
if (e.target.checked) {
this.addressForm
.get('permanentAddress')!
.patchValue(this.addressForm.get('presentAddress')!.value);
} else {
this.addressForm.get('permanentAddress')!.reset();
}
}

private saveSection(): void {
// merge into existing full form in localStorage
this.formService.savePartialData('addressForm', this.addressForm.value);
}

previous(): void {
// preserve section in storage, then navigate back
this.saveSection();
this.router.navigate(['/personal-info'], {
queryParams: this.fromReview ? { from: 'review' } : {}
});
}

next(): void {
if (this.addressForm.invalid) return;

this.saveSection();

if (this.fromReview) {
this.router.navigate(['/review-submit']);
} else {

this.router.navigate(['/education-info']);
}

}
}