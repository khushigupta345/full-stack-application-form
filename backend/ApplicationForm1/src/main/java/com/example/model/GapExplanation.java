package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GapExplanation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=true)
    private String fromDate;
    @Column(nullable=true)
    private String toDate;
    @Column(nullable=true)
    private String reason;
   

    @ManyToOne
    @JoinColumn()
    private ApplicationForm applicationForm;
}