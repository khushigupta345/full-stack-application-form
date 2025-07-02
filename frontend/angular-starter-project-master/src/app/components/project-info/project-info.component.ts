import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FormserviceService } from 'src/app/services/formservice.service';


@Component({
  selector: 'app-project-info',
  templateUrl: './project-info.component.html',
  styleUrls: ['./project-info.component.css']
})
export class ProjectInfoComponent {
  projectForm: FormGroup;
  fromReview = false;
  constructor(
    private fb: FormBuilder,
    private router: Router,
    private formService: FormserviceService,
    private route:ActivatedRoute

  ) {
    this.fromReview = this.route.snapshot.queryParamMap.get('from') === 'review';

    this.projectForm = this.fb.group({
      projects: this.fb.array([this.createProjectGroup()])
    });
    
  }
ngOnInit(): void {
    // Load saved data if available
    const saved = this.formService.getSectionData('projectForm');
    if (saved) {
      this.projectForm.patchValue(saved);
    }
  }
  get projects(): FormArray {
    return this.projectForm.get('projects') as FormArray;
  }

  createProjectGroup(): FormGroup {
    return this.fb.group({
      title: ['', Validators.required],
      company: ['', Validators.required],
      client: [''],
      skills: ['', Validators.required],
      teamSize: ['', Validators.required],
      role: ['', Validators.required],
    });
  }


  addProject() {
    if (this.projects.length < 3) {
      this.projects.push(this.createProjectGroup());
    }
  }

  removeProject(index: number) {
    if (this.projects.length > 1) {
      this.projects.removeAt(index);
    }
  }

  previous() {
    this.router.navigate(['/achievement-info']);
  }

  next() {
    this.formService.savePartialData('projectForm', this.projectForm.value);
    this.router.navigate(['/employment-info']);
  }
}