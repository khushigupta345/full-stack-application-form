package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable=false)
    private String degree;
	@Column(nullable=false)
    private String course;
	@Column(nullable=false)
    private String elective;
	@Column(nullable=false)
    private String collegeName;
	@Column(nullable=false)
    private String collegeAddress;
	@Column(nullable=false)
    private String universityName;
	@Column(nullable=false)
    private String universityAddress;
	@Column(nullable=false)
    private String fromYear;
	@Column(nullable=false)
    private String toYear;
	@Column(nullable=false)
    private String percentage;
 

    
    @ManyToOne
    @JoinColumn()
    private ApplicationForm applicationForm;
}