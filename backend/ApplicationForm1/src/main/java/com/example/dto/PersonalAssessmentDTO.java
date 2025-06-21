package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalAssessmentDTO {
	@NotBlank(message = "Strengths are required")
   
    private String strength;

    @NotBlank(message = "Weaknesses are required")
   
    private String weaknesse;

    
	 @NotBlank(message = "Short-term goal is required")
    
    private String shortTermGoal;

    @NotBlank(message = "Long-term goal is required")
   
    private String longTermGoal;
    @NotBlank(message = "Long-term goal is required")
    
    private String  hobbie;

   
}