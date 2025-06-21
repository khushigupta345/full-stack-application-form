package com.example.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable=false)

    private String title;
	@Column(nullable=false)
    private String company;
    @Column(nullable=true)
    private String client;
	@Column(nullable=false)
 
    private String skills;
	@Column(nullable=false)
    private String teamSize;
	@Column(nullable=false)
    private String role;

    @ManyToOne
    @JoinColumn()
    private ApplicationForm applicationForm;
}