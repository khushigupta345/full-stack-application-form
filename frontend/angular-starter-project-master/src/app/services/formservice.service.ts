
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class FormserviceService {

  private formData: { [key: string]: any } = {};
  private photoFile: File | null = null;
  private chartFile: File | null = null;

  constructor(private http: HttpClient, private auth: AuthService) {
    this.loadFromStorage();
  }

  savePartialData(section: string, data: any): void {
    this.formData[section] = data;
    localStorage.setItem('mnjFormData', JSON.stringify(this.formData));
  }

  getSectionData(section: string): any {
    return this.formData[section] || {};
  }

  
private tempFormData: any = null;

setTempFormData(data: any) {
  this.tempFormData = data;
}

getTempFormData(): any {
  return this.tempFormData;
}
getFormData(): any {
  const saved = localStorage.getItem('mnjFormData');
  if (saved) {
    const allSections = JSON.parse(saved);
    const merged: any = {};
    for (const section in allSections) {
      Object.assign(merged, allSections[section]);
    }
    return merged;
  }
  return {};
}
  setFiles(photo: File | null, chart: File | null): void {
    this.photoFile = photo;
    this.chartFile = chart;
  }

  loadFromStorage(): void {
    const saved = localStorage.getItem('mnjFormData');
    if (saved) {
      this.formData = JSON.parse(saved);
    }
  }

  clearFormData(): void {
    this.formData = {};
    this.photoFile = null;
    this.chartFile = null;
    localStorage.removeItem('mnjFormData');
  }

  hasSubmitted(): boolean {
    return localStorage.getItem('formSubmitted') === 'true';
  }

  setSubmitted(): void {
    localStorage.setItem('formSubmitted', 'true');
  }

  hasUpdated(): boolean {
    return localStorage.getItem('formUpdated') === 'true';
  }

  setUpdated(): void {
    localStorage.setItem('formUpdated', 'true');
  }

  // Submit Form 
  submitForm(): Observable<any> {
    const data = this.getFormData();

    data.personalAssessment = {
      strength: data.strength,
      weaknesse: data.weaknesse,
      shortTermGoal: data.shortTermGoal,
      longTermGoal: data.longTermGoal,
      hobbie: data.hobbie
    };

    delete data.strength;
    delete data.weaknesse;
    delete data.shortTermGoal;
    delete data.longTermGoal;
    delete data.hobbie;

    const fd = new FormData();
    fd.append('data', new Blob([JSON.stringify(data)], { type: 'application/json' }));

    if (this.photoFile) {
      fd.append('photo', this.photoFile);
    }
    if (this.chartFile) {
      fd.append('chart', this.chartFile);
    }

    const token = this.auth.getToken();
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`
    });

    return this.http.post('http://localhost:8034/api/application/submit', fd, {headers,responseType: 'json'  });
  }

  

  //  Get My Form API
  getMyForm(): Observable<any> {

    // const token = this.auth.getToken();
    // const headers = new HttpHeaders({
    //   Authorization:` Bearer ${token}`
    // });
    

    return this.http.get('http://localhost:8034/api/application/my-form' );
  }


 finalUpdatePersonalAndAddress(formData: FormData): Observable<any> {
  console.log("mahi",formData)
    // const token = this.auth.getToken();
    // const headers = new HttpHeaders({
    //   Authorization: `Bearer ${token}`
    // });

    return this.http.put(
      'http://localhost:8034/api/application/update-personal-address',
      formData,
      // { headers }
    );
  }
}