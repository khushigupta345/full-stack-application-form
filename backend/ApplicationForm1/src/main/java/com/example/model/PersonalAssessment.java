package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable=false)
    private String strength;
	@Column(nullable=false)
    private String weaknesse;
	@Column(nullable=false)
    private String shortTermGoal;
	@Column(nullable=false)
    private String longTermGoal;
	@Column(nullable=false)
    private String hobbie;

    @OneToOne
    @JoinColumn()
    private ApplicationForm applicationForm;
}