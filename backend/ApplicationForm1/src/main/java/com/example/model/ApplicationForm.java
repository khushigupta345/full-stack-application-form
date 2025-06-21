package com.example.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(nullable=false)
    private String fullName;
@Column(nullable=false)
    private String fatherName;
@Column(nullable=false)
    private String email;
@Column(nullable=false)
    private String phone;
@Column(nullable=false)
    private String gender;
@Column(nullable=false)
    private String maritalStatus;
@Column(nullable=false)

    private String dob;
@Column(nullable=false)
    private String panCard;
    @Column(nullable=false)
    private String nationality;
    @Column(nullable=false)
    private String placeOfBirth;
    @Column(nullable=false)
    private String declarationSignedBy;
    @Column(nullable=false)
    private String declarationDate;

    private String organizationChartFilename;
    @Column(nullable=false)
    private String photoFilename;
    @Column(nullable=false)
    private String attendedInterviewIn6Months;
    private String hasVisa;
    @Column(nullable=false)
    private String willingToTravel;

    @Embedded
    private Address presentAddress;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "houseNo", column = @Column(name = "permanent_houseNo")),
        @AttributeOverride(name = "city", column = @Column(name = "permanent_city")),
        @AttributeOverride(name = "state", column = @Column(name = "permanent_state")),
        @AttributeOverride(name = "pinCode", column = @Column(name = "permanent_pinCode")),
        @AttributeOverride(name = "country", column = @Column(name = "permanent_country"))
    })
    private Address permanentAddress;
    @JsonIgnore
    @OneToMany(mappedBy = "applicationForm", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Education> educationList = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "applicationForm", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<FamilyMember> familyMembers = new ArrayList<>();
    @JsonIgnore
    @OneToOne(mappedBy = "applicationForm", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private PassportDetails passportDetails;
    @JsonIgnore
//    @OneToMany(mappedBy = "applicationForm", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Language> languageProficiencies = new ArrayList<>();
    @OneToMany(mappedBy = "applicationForm", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Languageproficiency> languageProficiencies = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "applicationForm", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Training> trainings = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "applicationForm", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Achievement> achievements = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "applicationForm", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<ProjectInfo> projects = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "applicationForm", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<EmploymentHistory> employmentHistories = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "applicationForm", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Referee> referees = new ArrayList<>();
    @JsonIgnore
    @OneToOne(mappedBy = "applicationForm", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private PersonalAssessment personalAssessment;
    @JsonIgnore
    @OneToMany(mappedBy = "applicationForm", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<AdditionalQualification> additionalQualifications = new ArrayList<>();
@JsonIgnore
    @OneToMany(mappedBy = "applicationForm", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<GapExplanation> gapExplanations = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "user_id")
    
    @ToString.Exclude
    private User user;
}