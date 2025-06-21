package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Referee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable=false)
    private String name;
	@Column(nullable=false)
    private String designation;
    @Column(nullable=true)
    private String company;
	@Column(nullable=false)
    private String contact;


    @ManyToOne
    @JoinColumn()
    private ApplicationForm applicationForm;
}