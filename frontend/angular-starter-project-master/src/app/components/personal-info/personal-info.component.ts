
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FormserviceService } from 'src/app/services/formservice.service';

@Component({
  selector: 'app-personal-info',
  templateUrl: './personal-info.component.html',
  styleUrls: ['./personal-info.component.css']
})
export class PersonalInfoComponent implements OnInit {
  personalForm: FormGroup;
  photoFile: File | null = null;
  chartFile: File | null = null;
  photoPreviewUrl: string | ArrayBuffer | null = null;
  chartPreviewUrl: string | ArrayBuffer | null = null;
  fromReview = false;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private formService: FormserviceService,
    private route: ActivatedRoute
  ) {
    this.personalForm = this.fb.group({
      fullName: ['', Validators.required],
      fatherName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      gender: ['', Validators.required],
      maritalStatus: ['', Validators.required],
      dob: ['', Validators.required],
      panCard: ['', Validators.required],
      nationality: ['', Validators.required],
      placeOfBirth: ['', Validators.required],
      attendedInterviewIn6Months: ['', Validators.required],
      hasVisa: ['', Validators.required],
      willingToTravel: ['', Validators.required],
     
    });
  }

ngOnInit(): void {
   
    // add by me
    const saved = this.formService.getSectionData('personalForm');
    if (saved) {
      this.personalForm.patchValue(saved);
    }
    //
  this.route.queryParams.subscribe(params => {
    this.fromReview = params['from'] === 'review';

    let data: any = {};

    if (this.fromReview) {
      data = this.formService.getTempFormData() || {};
      console.log(" FormData from service (review):", data);
    } else {
      data = JSON.parse(localStorage.getItem('mnjFormData') || '{}');
      console.log(" FormData from localStorage:", data);
    }

    this.personalForm.patchValue({
      fullName: data.fullName || '',
      fatherName: data.fatherName || '',
      email: data.email || '',
      phone: data.phone || '',
      gender: data.gender || '',
      maritalStatus: data.maritalStatus || '',
      dob: data.dob || '',
      panCard: data.panCard || '',
      nationality: data.nationality || '',
      placeOfBirth: data.placeOfBirth || '',
      attendedInterviewIn6Months: data.attendedInterviewIn6Months || '',
      hasVisa: data.hasVisa || '',
      willingToTravel: data.willingToTravel || '',
     
    });

    console.log(" Patched personalForm:", this.personalForm.value);
  });
}

  onPhotoChange(event: any): void {
    const file = event.target.files[0];
    this.photoFile = file;
    if (file) {
      const reader = new FileReader();
      reader.onload = () => {
        this.photoPreviewUrl = reader.result;
      };
      reader.readAsDataURL(file);
    }
  }

  onChartChange(event: any): void {
    const file = event.target.files[0];
    this.chartFile = file;
    if (file) {
      const reader = new FileReader();
      reader.onload = () => {
        this.chartPreviewUrl = reader.result;
      };
      reader.readAsDataURL(file);
    }
  }

  // saveToLocal(): void {
  //   const existing = JSON.parse(localStorage.getItem('mnjFormData') || '{}');
  //   const current = this.personalForm.value;

  //   const flat = {
  //     fullName: current.fullName,
  //     fatherName: current.fatherName,
  //     email: current.email,
  //     phone: current.phone,
  //     gender: current.gender,
  //     maritalStatus: current.maritalStatus,
  //     dob: current.dob,
  //     panCard: current.panCard,
  //     nationality: current.nationality,
  //     placeOfBirth: current.placeOfBirth,
  //     attendedInterviewIn6Months: current.attendedInterviewIn6Months,
  //     hasVisa: current.hasVisa,
  //     willingToTravel: current.willingToTravel,
      
  //   };

  //   const updated = { ...existing, ...flat };
  //   localStorage.setItem('mnjFormData', JSON.stringify(updated));
  // }

  next(): void {
    // this.saveToLocal();
        this.formService.savePartialData('personalForm', this.personalForm.value);
    this.formService.setFiles(this.photoFile, this.chartFile);

    if (this.fromReview) {
      this.router.navigate(['/review-submit']);
    } else {
      this.router.navigate(['/address-info']);
    }
  }
}