package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassportDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passportNumber;
    private String dateOfIssue;
    private String dateOfExpiry;
    private String placeOfIssue;


    @OneToOne
    @JoinColumn()
    private ApplicationForm applicationForm;
}