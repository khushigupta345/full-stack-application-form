package com.example.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GapExplanationDTO {
    private String fromDate;
    private String toDate;
    private String reason;
 
}