package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String designation;
    private String location;
    private String employmentFrom;
    private String employmentTo;
    @Column(nullable=true)
    private String hrName;
    @Column(nullable=true)
    private String hrEmail;
    @Column(nullable=true)
    private String hrContact;
    @Column(nullable=true)
    private String reportingManager;
    @Column(nullable=true)
    private String managerEmail;
    @Column(nullable=true)
    private String ctc;
    @Column(nullable=true)
    private String reasonForLeaving;

    @ManyToOne
    @JoinColumn()
    private ApplicationForm applicationForm;
}