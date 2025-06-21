import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FormserviceService } from 'src/app/services/formservice.service';


@Component({
  selector: 'app-achievement-info',
  templateUrl: './achievement-info.component.html',
  styleUrls: ['./achievement-info.component.css']
})
export class AchievementInfoComponent {
  achievementForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private formService: FormserviceService) {
    this.achievementForm = this.fb.group({
      achievements: this.fb.array([this.createAchievementGroup()])
    });
  }

  get achievements(): FormArray {
    return this.achievementForm.get('achievements') as FormArray;
  }

  createAchievementGroup(): FormGroup {
    return this.fb.group({
      description: ['', Validators.required],
      year: ['']
    });
  }

  addAchievement() {
    this.achievements.push(this.createAchievementGroup());
  }

  removeAchievement(index: number) {
    if (this.achievements.length > 1) {
      this.achievements.removeAt(index);
    }
  }

  previous() {
    this.router.navigate(['/training-info']);
  }

  next() {
    this.formService.savePartialData('achievementForm', this.achievementForm.value);
    this.router.navigate(['/project-info']);
  }
}