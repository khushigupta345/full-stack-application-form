package com.example.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
 @NotBlank  private String name;
 @NotBlank   private String email;
 @NotBlank   private String password;
 private boolean formSubmitted;
  private boolean formUpdated;

}