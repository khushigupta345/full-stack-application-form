package com.example.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdditionalQualificationDTO {
    private String program;
    private String institute;
    private String fromDate;
    private String toDate;
    private String percentage;
    private String division;
}