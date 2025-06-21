package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationFormDTO {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Father's name is required")
    private String fatherName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phone;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Marital status is required")
    private String maritalStatus;

    @NotBlank(message = "Date of birth is required")
    private String dob;

    @NotBlank(message = "PAN is required")
    private String panCard;

    @NotBlank(message = "Nationality is required")
    private String nationality;

    @NotBlank(message = "Place of birth is required")
    private String placeOfBirth;

    @NotBlank
    private String declarationSignedBy;
    private String declarationDate;

    
    private String photoFilename;
    
    private String organizationChartFilename;
    @NotBlank
    private String attendedInterviewIn6Months;
   

    @Valid
    private AddressDTO presentAddress;

    @Valid
    private AddressDTO permanentAddress;

    @Valid
    @Size(max = 4, message = "Maximum 4 education entries allowed")
    private List<EducationDTO> educationList;

    @Valid
    private List<FamilyMemberDTO> familyMembers;

   
    private PassportDetailsDTO passportDetails;

    @Valid
    @Size(max = 4, message = "Maximum 4 languages allowed")
    private List<LanguageDTO> languageProficiencies;

    @Valid
    private List<TrainingDTO> trainings;

    @Valid
    private List<AchievementDTO> achievements;

    @Valid
    @Size(max = 3, message = "Maximum 3 projects allowed")
    private List<ProjectInfoDTO> projects;

    
    @Size(max = 3, message = "Maximum 3 previous employments allowed")
    private List<EmploymentHistoryDTO> employmentHistories;

    @Valid
    @Size(max = 2, message = "Maximum 2 referees allowed")
    private List<RefereeDTO> referees;

    @Valid
    private PersonalAssessmentDTO personalAssessment;

    @Valid
    private List<AdditionalQualificationDTO> additionalQualifications;

    @Valid
    private List<GapExplanationDTO> gapExplanations;
    @NotBlank
    private String hasVisa;
    @NotBlank
    private String willingToTravel;
    private boolean formSubmitted;
    private boolean formUpdated;
    
}