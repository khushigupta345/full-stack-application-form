package com.example.mapper;


import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.dto.*;

import com.example.dto.TrainingDTO;
import com.example.model.Achievement;
import com.example.model.AdditionalQualification;
import com.example.model.Address;
import com.example.model.ApplicationForm;
import com.example.model.Education;
import com.example.model.EmploymentHistory;
import com.example.model.FamilyMember;
import com.example.model.GapExplanation;
import com.example.model.Languageproficiency;
import com.example.model.PassportDetails;
import com.example.model.PersonalAssessment;
import com.example.model.ProjectInfo;
import com.example.model.Referee;
import com.example.model.Training;



@Component
public class ApplicationFormMapper {

public Address mapAddress(AddressDTO dto) {  
    Address a = new Address();  
    a.setHouseNo(dto.getHouseNo());
    a.setCity(dto.getCity());  
    a.setState(dto.getState());  
    a.setPinCode(dto.getPinCode());  
    a.setCountry(dto.getCountry());  
    return a;  
}  

public Education mapEducation(EducationDTO dto,ApplicationForm form) {
    Education e = new Education();
    e.setDegree(dto.getDegree());
    e.setCourse(dto.getCourse());
    e.setElective(dto.getElective());
    e.setCollegeName(dto.getCollegeName());
    e.setCollegeAddress(dto.getCollegeAddress());
    e.setUniversityName(dto.getUniversityName());
    e.setUniversityAddress(dto.getUniversityAddress());
    e.setFromYear(dto.getFromYear());
    e.setToYear(dto.getToYear());
    e.setPercentage(dto.getPercentage());
    e.setApplicationForm(form);

    return e;
}

public FamilyMember mapFamilyMember(FamilyMemberDTO dto,ApplicationForm form) {
    FamilyMember f = new FamilyMember();
    f.setName(dto.getName());
    f.setRelationship(dto.getRelationship());
    f.setApplicationForm(form);
   
    return f;
}  

public PassportDetails mapPassport(PassportDetailsDTO dto,ApplicationForm form) {  
    PassportDetails p = new PassportDetails();  
    p.setPassportNumber(dto.getPassportNumber());  
    p.setPlaceOfIssue(dto.getPlaceOfIssue());  
    p.setDateOfIssue(dto.getDateOfIssue());  
    p.setDateOfExpiry(dto.getDateOfExpiry()); 
    p.setApplicationForm(form);
    return p;  
}  

public Languageproficiency  mapLanguage(LanguageDTO dto,ApplicationForm form) {  
	Languageproficiency l = new Languageproficiency();  
    l.setLanguage(dto.getLanguage());  
    l.setRead(dto.isRead());  
    l.setWrite(dto.isWrite());  
    l.setSpeak(dto.isSpeak());  
    l.setApplicationForm(form);
    return l;  
}  

public Training mapTraining(TrainingDTO dto,ApplicationForm form) {
	
    Training t = new Training();
    t.setSeminarName(dto.getSeminarName());
    t.setInstitution(dto.getInstitution());
    t.setConductedBy(dto.getConductedBy());
    t.setFromDate(dto.getFromDate());
    t.setToDate(dto.getToDate());
    t.setApplicationForm(form);
    return t;
}  

public Achievement mapAchievement(AchievementDTO dto, ApplicationForm form) {
    if ((dto.getYear() == null || dto.getYear().isBlank()) &&
        (dto.getDescription() == null || dto.getDescription().isBlank())) {
        return null; // skip if both year and description are blank
    }

    Achievement a = new Achievement();
    a.setYear(dto.getYear());
    a.setDescription(dto.getDescription());
    a.setApplicationForm(form);
    return a;
}
public ProjectInfo mapProject(ProjectInfoDTO dto,ApplicationForm form) {
    ProjectInfo p = new ProjectInfo();
    p.setTitle(dto.getTitle());
    p.setCompany(dto.getCompany());
    p.setClient(dto.getClient());

    p.setSkills(dto.getSkills());
    p.setTeamSize(dto.getTeamSize());
    p.setRole(dto.getRole());
    p.setApplicationForm(form);
    return p;
} 


public EmploymentHistory mapEmployment(EmploymentHistoryDTO dto, ApplicationForm form) {
    if ((dto.getCompanyName() == null || dto.getCompanyName().isBlank()) &&
        (dto.getDesignation() == null || dto.getDesignation().isBlank()) &&
        (dto.getEmploymentFrom() == null) &&
        (dto.getEmploymentTo() == null)) {
        return null; 
    }

    EmploymentHistory e = new EmploymentHistory();
    e.setCompanyName(dto.getCompanyName());
    e.setDesignation(dto.getDesignation());
    e.setLocation(dto.getLocation());
    e.setEmploymentFrom(dto.getEmploymentFrom());
    e.setEmploymentTo(dto.getEmploymentTo());
    e.setHrName(dto.getHrName());
    e.setHrEmail(dto.getHrEmail());
    e.setHrContact(dto.getHrContact());
    e.setReportingManager(dto.getReportingManager());
    e.setManagerEmail(dto.getManagerEmail());
    e.setCtc(dto.getCtc());
    e.setReasonForLeaving(dto.getReasonForLeaving());
    e.setApplicationForm(form);
    return e;
}
public Referee mapReferee(RefereeDTO dto,ApplicationForm form) {  
    Referee r = new Referee();  
    r.setName(dto.getName());  
    r.setDesignation(dto.getDesignation());  
    r.setCompany(dto.getCompany());  
    r.setContact(dto.getContact()); 
    r.setApplicationForm(form);
    return r;  
}  

public PersonalAssessment mapAssessment(PersonalAssessmentDTO dto,ApplicationForm form) { 
	
    PersonalAssessment p = new PersonalAssessment(); 
    
    p.setStrength(dto.getStrength());  
    
    p.setWeaknesse(dto.getWeaknesse());  
    p.setLongTermGoal(dto.getLongTermGoal());
    p.setShortTermGoal(dto.getLongTermGoal());
    p.setApplicationForm(form);
    p.setHobbie(dto.getHobbie());

    return p;  
}  

public AdditionalQualification mapAdditionalQualification(AdditionalQualificationDTO dto, ApplicationForm form) {
    if ((dto.getProgram() == null || dto.getProgram().isBlank()) &&
        (dto.getInstitute() == null || dto.getInstitute().isBlank()) &&
        dto.getFromDate() == null &&
        dto.getToDate() == null) {
        return null; 
    }

    AdditionalQualification aq = new AdditionalQualification();
    aq.setProgram(dto.getProgram());
    aq.setInstitute(dto.getInstitute());
    aq.setFromDate(dto.getFromDate());
    aq.setToDate(dto.getToDate());
    aq.setPercentage(dto.getPercentage());
    aq.setDivision(dto.getDivision());
    aq.setApplicationForm(form);
    return aq;
}
public GapExplanation mapGap(GapExplanationDTO dto, ApplicationForm form) {
    if ((dto.getFromDate() == null || dto.getFromDate().toString().isBlank()) &&
        (dto.getToDate() == null || dto.getToDate().toString().isBlank()) &&
        (dto.getReason() == null || dto.getReason().isBlank())) {
        return null; 
    }

    GapExplanation g = new GapExplanation();
    g.setFromDate(dto.getFromDate());
    g.setToDate(dto.getToDate());
    g.setReason(dto.getReason());
    g.setApplicationForm(form);
    return g;
}

// Entity to DTO Mapping 

public ApplicationFormDTO entityToDto(ApplicationForm form) {
 ApplicationFormDTO dto = new ApplicationFormDTO();

 dto.setFullName(form.getFullName());
 dto.setFatherName(form.getFatherName());
 dto.setEmail(form.getEmail());
 dto.setPhone(form.getPhone());
 dto.setGender(form.getGender());
 dto.setMaritalStatus(form.getMaritalStatus());
 dto.setDob(form.getDob());
 dto.setPanCard(form.getPanCard());
 dto.setNationality(form.getNationality());
 dto.setPlaceOfBirth(form.getPlaceOfBirth());
 dto.setDeclarationSignedBy(form.getDeclarationSignedBy());
 dto.setDeclarationDate(form.getDeclarationDate());
 dto.setHasVisa(form.getHasVisa());
 dto.setWillingToTravel(form.getWillingToTravel());
 dto.setAttendedInterviewIn6Months(form.getAttendedInterviewIn6Months());
 dto.setPhotoFilename(form.getPhotoFilename());
 dto.setOrganizationChartFilename(form.getOrganizationChartFilename());

 dto.setPresentAddress(mapAddressEntityToDTO(form.getPresentAddress()));
 dto.setPermanentAddress(mapAddressEntityToDTO(form.getPermanentAddress()));

 dto.setEducationList(form.getEducationList().stream().map(this::mapEducationEntityToDTO).collect(Collectors.toList()));
 dto.setFamilyMembers(form.getFamilyMembers().stream().map(this::mapFamilyMemberEntityToDTO).collect(Collectors.toList()));
 dto.setLanguageProficiencies(form.getLanguageProficiencies().stream().map(this::mapLanguageEntityToDTO).collect(Collectors.toList()));
 dto.setTrainings(form.getTrainings().stream().map(this::mapTrainingEntityToDTO).collect(Collectors.toList()));
 dto.setAchievements(form.getAchievements().stream().map(this::mapAchievementEntityToDTO).collect(Collectors.toList()));
 dto.setProjects(form.getProjects().stream().map(this::mapProjectEntityToDTO).collect(Collectors.toList()));
 dto.setEmploymentHistories(form.getEmploymentHistories().stream().map(this::mapEmploymentEntityToDTO).collect(Collectors.toList()));
 dto.setReferees(form.getReferees().stream().map(this::mapRefereeEntityToDTO).collect(Collectors.toList()));
 dto.setAdditionalQualifications(form.getAdditionalQualifications().stream().map(this::mapAdditionalQualificationEntityToDTO).collect(Collectors.toList()));
 dto.setGapExplanations(form.getGapExplanations().stream().map(this::mapGapEntityToDTO).collect(Collectors.toList()));

 dto.setPassportDetails(mapPassportEntityToDTO(form.getPassportDetails()));
 dto.setPersonalAssessment(mapAssessmentEntityToDTO(form.getPersonalAssessment()));

 return dto;
}

public AddressDTO mapAddressEntityToDTO(Address address) {
 if (address == null) return null;
 AddressDTO dto = new AddressDTO();
 dto.setHouseNo(address.getHouseNo());
 dto.setCity(address.getCity());
 dto.setState(address.getState());
 dto.setPinCode(address.getPinCode());
 dto.setCountry(address.getCountry());
 return dto;
}

public EducationDTO mapEducationEntityToDTO(Education edu) {
 EducationDTO dto = new EducationDTO();
 dto.setDegree(edu.getDegree());
 dto.setCourse(edu.getCourse());
 dto.setElective(edu.getElective());
 dto.setCollegeName(edu.getCollegeName());
 dto.setCollegeAddress(edu.getCollegeAddress());
 dto.setUniversityName(edu.getUniversityName());
 dto.setUniversityAddress(edu.getUniversityAddress());
 dto.setFromYear(edu.getFromYear());
 dto.setToYear(edu.getToYear());
 dto.setPercentage(edu.getPercentage());
 return dto;
}

public FamilyMemberDTO mapFamilyMemberEntityToDTO(FamilyMember member) {
 FamilyMemberDTO dto = new FamilyMemberDTO();
 dto.setName(member.getName());
 dto.setRelationship(member.getRelationship());
 return dto;
}

public LanguageDTO mapLanguageEntityToDTO(Languageproficiency lang) {
 LanguageDTO dto = new LanguageDTO();
 dto.setLanguage(lang.getLanguage());
 dto.setRead(lang.isRead());
 dto.setWrite(lang.isWrite());
 dto.setSpeak(lang.isSpeak());
 return dto;
}

public TrainingDTO mapTrainingEntityToDTO(Training training) {
 TrainingDTO dto = new TrainingDTO();
 dto.setSeminarName(training.getSeminarName());
 dto.setInstitution(training.getInstitution());
 dto.setConductedBy(training.getConductedBy());
 dto.setFromDate(training.getFromDate());
 dto.setToDate(training.getToDate());
 return dto;
}

public AchievementDTO mapAchievementEntityToDTO(Achievement ach) {
 AchievementDTO dto = new AchievementDTO();
 dto.setYear(ach.getYear());
 dto.setDescription(ach.getDescription());
 return dto;
}

public ProjectInfoDTO mapProjectEntityToDTO(ProjectInfo proj) {
 ProjectInfoDTO dto = new ProjectInfoDTO();
 dto.setTitle(proj.getTitle());
 dto.setCompany(proj.getCompany());
 dto.setClient(proj.getClient());
 dto.setSkills(proj.getSkills());
 dto.setTeamSize(proj.getTeamSize());
 dto.setRole(proj.getRole());
 return dto;
}

public EmploymentHistoryDTO mapEmploymentEntityToDTO(EmploymentHistory emp) {
 EmploymentHistoryDTO dto = new EmploymentHistoryDTO();
 dto.setCompanyName(emp.getCompanyName());
 dto.setDesignation(emp.getDesignation());
 dto.setLocation(emp.getLocation());
 dto.setEmploymentFrom(emp.getEmploymentFrom());
 dto.setEmploymentTo(emp.getEmploymentTo());
 dto.setHrName(emp.getHrName());
 dto.setHrEmail(emp.getHrEmail());
 dto.setHrContact(emp.getHrContact());
 dto.setReportingManager(emp.getReportingManager());
 dto.setManagerEmail(emp.getManagerEmail());
 dto.setCtc(emp.getCtc());
 dto.setReasonForLeaving(emp.getReasonForLeaving());
 return dto;
}

public RefereeDTO mapRefereeEntityToDTO(Referee ref) {
 RefereeDTO dto = new RefereeDTO();
 dto.setName(ref.getName());
 dto.setDesignation(ref.getDesignation());
 dto.setCompany(ref.getCompany());
 dto.setContact(ref.getContact());
 return dto;
}

public AdditionalQualificationDTO mapAdditionalQualificationEntityToDTO(AdditionalQualification add) {
 AdditionalQualificationDTO dto = new AdditionalQualificationDTO();
 dto.setProgram(add.getProgram());
 dto.setInstitute(add.getInstitute());
 dto.setFromDate(add.getFromDate());
 dto.setToDate(add.getToDate());
 dto.setPercentage(add.getPercentage());
 dto.setDivision(add.getDivision());
 return dto;
}

public GapExplanationDTO mapGapEntityToDTO(GapExplanation gap) {
 GapExplanationDTO dto = new GapExplanationDTO();
 dto.setFromDate(gap.getFromDate());
 dto.setToDate(gap.getToDate());
 dto.setReason(gap.getReason());
 return dto;
}

public PassportDetailsDTO mapPassportEntityToDTO(PassportDetails pass) {
 if (pass == null) return null;
 PassportDetailsDTO dto = new PassportDetailsDTO();
 dto.setPassportNumber(pass.getPassportNumber());
 dto.setPlaceOfIssue(pass.getPlaceOfIssue());
 dto.setDateOfIssue(pass.getDateOfIssue());
 dto.setDateOfExpiry(pass.getDateOfExpiry());
 return dto;
}

public PersonalAssessmentDTO mapAssessmentEntityToDTO(PersonalAssessment assessment) {
 if (assessment == null) return null;
 PersonalAssessmentDTO dto = new PersonalAssessmentDTO();
 dto.setStrength(assessment.getStrength());
 dto.setWeaknesse(assessment.getWeaknesse());
 dto.setLongTermGoal(assessment.getLongTermGoal());
 dto.setShortTermGoal(assessment.getShortTermGoal());
 dto.setHobbie(assessment.getHobbie());
 return dto;
}


}