package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDTO {
 @NotBlank   private String seminarName;
 @NotBlank   private String  institution;
 @NotBlank     private String conductedBy;
 @NotBlank      private String fromDate;
 @NotBlank    private String toDate;
}