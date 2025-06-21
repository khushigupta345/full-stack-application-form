package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Languageproficiency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @Column(name = "language_name")
    private String language;

    @Column(name = "can_read")
    private boolean read;

    @Column(name = "can_write")
    private boolean write;

    @Column(name = "can_speak")
    private boolean speak;

    @ManyToOne
    @JoinColumn(name = "application_form_id")
    private ApplicationForm applicationForm;
}