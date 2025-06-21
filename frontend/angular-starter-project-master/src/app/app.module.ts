import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import { NzLayoutModule } from 'ng-zorro-antd/layout';

import { JwtInterceptor } from './interceptors/jwt.interceptor';


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

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    PersonalInfoComponent,
    AddressInfoComponent,
    EducationInfoComponent,
    FamilyInfoComponent,
    PassportInfoComponent,
    LanguageInfoComponent,
    TrainingInfoComponent,
    AchievementInfoComponent,
    ProjectInfoComponent,
    EmploymentInfoComponent,
    RefereeInfoComponent,
    AssessmentInfoComponent,
    QualificationInfoComponent,
    GapInfoComponent,
    DeclarationInfoComponent,
    ReviewSubmitComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NzLayoutModule
  ],
  providers: [
    { provide: NZ_I18N, useValue: en_US },
    
    
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }