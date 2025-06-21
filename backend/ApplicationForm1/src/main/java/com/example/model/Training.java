package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable=false)

    private String seminarName;
	@Column(nullable=false)
    private String institution;
	@Column(nullable=false)
    private String conductedBy;
	@Column(nullable=false)
    private String fromDate;
	@Column(nullable=false)
    private String toDate;

    @ManyToOne
    @JoinColumn()
    private ApplicationForm applicationForm;
}