package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdditionalQualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=true)
    private String program;
    @Column(nullable=true)
    private String institute;
    @Column(nullable=true)
    private String fromDate;
    @Column(nullable=true)
    private String toDate;
    @Column(nullable=true)
    private String percentage
    ;
    @Column(nullable=true)
    private String division;

    @ManyToOne
    @JoinColumn()
    private ApplicationForm applicationForm;
}