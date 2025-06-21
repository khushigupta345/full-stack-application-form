package com.example.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true)
  private String name;
  @Column(unique = true)
  private String email;
  @Column(nullable=false)
  private String password;
  private boolean formSubmitted = false; 
 
  private boolean formUpdated;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
  @JsonIgnore
  @ToString.Exclude
  private ApplicationForm applicationForm;
}