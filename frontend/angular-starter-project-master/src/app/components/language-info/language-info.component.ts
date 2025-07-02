import { Component } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FormserviceService } from 'src/app/services/formservice.service';

@Component({
  selector: 'app-language-info',
  templateUrl: './language-info.component.html',
  styleUrls: ['./language-info.component.css']
})
export class LanguageInfoComponent {
  languageForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private formService: FormserviceService) {
    this.languageForm = this.fb.group({
      languageProficiencies: this.fb.array([this.createLanguageGroup()])
    });
  }

  get languageProficiencies(): FormArray {
    return this.languageForm.get('languageProficiencies') as FormArray;
  }
ngOnInit(): void {
    // Load saved data if available
    const saved = this.formService.getSectionData('languageForm');
    if (saved) {
      this.languageForm.patchValue(saved);
    }
  }

  // createLanguageGroup(): FormGroup {
  //   return this.fb.group({
  //     language: ['', Validators.required],
  //     read: [false],
  //     write: [false],
  //     speak: [false]
  //   }, { validators: this.atLeastOneSkillSelected });
  // }
  createLanguageGroup(): FormGroup {
    return this.fb.group({
      language: ['', Validators.required],
      read: [false],
      write: [false],
      speak: [false]
    },)};

  // atLeastOneSkillSelected(group: AbstractControl): ValidationErrors | null {
  //   const read = group.get('read')?.value;
  //   const write = group.get('write')?.value;
  //   const speak = group.get('speak')?.value;
  //   return (read || write || speak) ? null : { noSkillSelected: true };
  // }

  addLanguage() {
    if (this.languageProficiencies.length < 4) {
      this.languageProficiencies.push(this.createLanguageGroup());
    }
  }

  removeLanguage(index: number) {
    if (this.languageProficiencies.length > 1) {
      this.languageProficiencies.removeAt(index);
    }
  }

  previous() {
    this.router.navigate(['/passport-info']);
  }

  next() {
    this.formService.savePartialData('languageForm', this.languageForm.value);
    this.router.navigate(['/training-info']);
  }
}