import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PersonalInfoComponent } from './components/personal-info/personal-info.component';
import { AddressInfoComponent } from './components/address-info/address-info.component';
import { EducationInfoComponent } from './components/education-info/education-info.component';
import { FamilyInfoComponent } from './components/family-info/family-info.component';
import { PassportInfoComponent } from './components/passport-info/passport-info.component';
import { LanguageInfoComponent } from './components/language-info/language-info.component';
import { TrainingInfoComponent } from './components/training-info/training-info.component';
import { AchievementInfoComponent } from './components/achievement-info/achievement-info.component';
import { ProjectInfoComponent } from './components/project-info/project-info.component';
import { EmploymentInfoComponent } from './components/employment-info/employment-info.component';
import { RefereeInfoComponent } from './components/referee-info/referee-info.component';
import { AssessmentInfoComponent } from './components/assessment-info/assessment-info.component';
import { QualificationInfoComponent } from './components/qualification-info/qualification-info.component';
import { GapInfoComponent } from './components/gap-info/gap-info.component';
import { DeclarationInfoComponent } from './components/declaration-info/declaration-info.component';
import { ReviewSubmitComponent } from './components/review-submit/review-submit.component';
import { SignupComponent } from './components/signup/signup.component';

const routes: Routes = [
  { path: '', redirectTo: 'signup', pathMatch: 'full' },
     { path: 'signup', component: SignupComponent },
 
  { path: 'personal-info', component: PersonalInfoComponent },
  { path: 'address-info', component: AddressInfoComponent },
  { path: 'education-info', component: EducationInfoComponent },
  { path: 'family-info', component: FamilyInfoComponent },
  { path: 'passport-info', component: PassportInfoComponent },
  { path: 'language-info', component: LanguageInfoComponent },
  { path: 'training-info', component: TrainingInfoComponent },
  { path: 'achievement-info', component: AchievementInfoComponent },
  { path: 'project-info', component: ProjectInfoComponent },
  { path: 'employment-info', component: EmploymentInfoComponent },
  { path: 'referee-info', component: RefereeInfoComponent },
  { path: 'assessment-info', component: AssessmentInfoComponent },
  { path: 'qualification-info', component: QualificationInfoComponent },
  { path: 'gap-info', component: GapInfoComponent },
  { path: 'declaration-info', component: DeclarationInfoComponent },
  { path: 'review-submit', component: ReviewSubmitComponent },

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}