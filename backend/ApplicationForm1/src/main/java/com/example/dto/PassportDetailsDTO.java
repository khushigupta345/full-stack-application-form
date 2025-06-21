package com.example.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassportDetailsDTO {

    private String passportNumber;
    private String dateOfIssue;
    private String dateOfExpiry;
    private String placeOfIssue;
}