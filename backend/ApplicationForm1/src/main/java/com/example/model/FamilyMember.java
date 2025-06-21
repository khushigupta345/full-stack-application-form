package com.example.model;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable=false)
    private String name;
	@Column(nullable=false)
    private String relationship;

    
    @ManyToOne
    @JoinColumn()
    private ApplicationForm applicationForm;
}