package com.example.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDTO {

    @NotBlank
    private String degree;

    @NotBlank
    private String course;

    @NotBlank
    private String elective;

    @NotBlank
    private String collegeName;

    @NotBlank
    private String collegeAddress;

    @NotBlank
    private String universityName;

    @NotBlank
    private String universityAddress;

    @NotBlank
    private String fromYear;

    @NotBlank
    private String toYear;

    @NotBlank
    private String percentage;
}