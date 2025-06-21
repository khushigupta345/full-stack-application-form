
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormserviceService } from 'src/app/services/formservice.service';

@Component({
  selector: 'app-review-submit',
  templateUrl: './review-submit.component.html',
  styleUrls: ['./review-submit.component.css']
})
export class ReviewSubmitComponent implements OnInit {
  allData: any;
  editable = false;
  submitting = false;
  updateDone = false;

  selectedPhotoFile: File | null = null;
  selectedChartFile: File | null = null;

  constructor(
    private formService: FormserviceService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.loadForm();
  }
loadForm(): void {
  this.formService.getMyForm().subscribe({
    next: (backendData) => {
      const local = localStorage.getItem('mnjFormData');
      let finalData = { ...backendData };

      if (local) {
        const edited = JSON.parse(local);
        for (const sectionKey in edited) {
          const section = edited[sectionKey];
          if (typeof section === 'object') {
            Object.assign(finalData, section); 
          } else {
            finalData[sectionKey] = section;
          }
        }
      }

      
      if (finalData.addressForm) {
        finalData.presentAddress = finalData.addressForm.presentAddress;
        finalData.permanentAddress = finalData.addressForm.permanentAddress;
      }

      this.allData = finalData;
      
      const submitted = backendData.formSubmitted || false;
      const updated = backendData.formUpdated || false;
      const isReadOnly = this.route.snapshot.queryParams['readonly'] === 'true';

      if (!submitted) {
        this.router.navigate(['/personal-info']);
        return;
      }

      this.editable = !(isReadOnly || updated);
      this.updateDone = updated;
    },
    error: () => {
      alert(" Failed to load form data.");
    }
  });
}
  onPhotoSelected(event: any): void {
    this.selectedPhotoFile = event.target.files[0];
  }

  onChartSelected(event: any): void {
    this.selectedChartFile = event.target.files[0];
  }


editSection(section: string): void {
  if (this.editable) {
    const flattened = {
      fullName: this.allData.fullName || '',
      fatherName: this.allData.fatherName || '',
      email: this.allData.email || '',
      phone: this.allData.phone || '',
      gender: this.allData.gender || '',
      maritalStatus: this.allData.maritalStatus || '',
      dob: this.allData.dob || '',
      panCard: this.allData.panCard || '',
      nationality: this.allData.nationality || '',
      placeOfBirth: this.allData.placeOfBirth || '',
      attendedInterviewIn6Months: this.allData.attendedInterviewIn6Months || '',
      hasVisa: this.allData.hasVisa || '',
      willingToTravel: this.allData.willingToTravel || '',
      declarationSignedBy: this.allData.declarationSignedBy || '',
      declarationDate: this.allData.declarationDate || '',
      presentAddress: this.allData.presentAddress || {},
      permanentAddress: this.allData.permanentAddress || {}
    };

    this.formService.setTempFormData(flattened); 

    this.router.navigate([`/${section}`], {
      queryParams: { from: 'review' }
    });
  }

}


finalUpdate(): void {
  if (!this.allData) {
    alert(" Data not loaded yet.");
    return;
  }

  this.submitting = true;

  const allowedKeys = [
    "fullName", "fatherName", "email", "phone", "gender", "maritalStatus",
    "dob", "panCard", "nationality", "placeOfBirth", "hasVisa", "willingToTravel",
    "declarationSignedBy", "declarationDate", "attendedInterviewIn6Months",
    "presentAddress", "permanentAddress"
  ];

  const cleanData: any = {};
  for (const key of allowedKeys) {
    const value = this.allData[key];
    if (value !== undefined && value !== null) {
      cleanData[key] = value;
    }
  }

  const formData = new FormData();
  formData.append("data", new Blob([JSON.stringify(cleanData)], { type: 'application/json' }));

  if (this.selectedPhotoFile) {
    formData.append("photo", this.selectedPhotoFile);
  }
  if (this.selectedChartFile) {
    formData.append("chart", this.selectedChartFile);
  }

  console.log(" Final Data sent to Backend:", cleanData);

  this.formService.finalUpdatePersonalAndAddress(formData).subscribe({
    next: () => {
      this.submitting = false;
      this.editable = false;
      this.updateDone = true;
      this.formService.setUpdated();
      localStorage.removeItem('mnjFormData');
      alert(" Update successful");
      this.loadForm(); 
    },
    error: (err) => {
      this.submitting = false;
      console.error(" Update failed:", err);
      alert(" Update failed: Please check required fields");
    }
  });
}
}