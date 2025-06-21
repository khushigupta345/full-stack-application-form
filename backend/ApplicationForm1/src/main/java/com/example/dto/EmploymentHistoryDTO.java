package com.example.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentHistoryDTO {
     
    private String companyName;
    private String designation;
    private String location;
    private String employmentFrom;
    private String employmentTo;
    private String hrName;
    private String hrEmail;
    private String hrContact;
    private String reportingManager;
    private String managerEmail;
    private String ctc;
    private String reasonForLeaving;
}