package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInfoDTO {
    @NotBlank private String title;
    @NotBlank  private String company;
      private String client;

    @NotBlank  private String skills;
    @NotBlank  private String teamSize;
    @NotBlank  private String role;
}