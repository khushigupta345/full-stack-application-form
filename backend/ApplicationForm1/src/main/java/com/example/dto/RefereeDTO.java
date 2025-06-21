package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefereeDTO {
    @NotBlank private String name;
    private String designation;
    private String company;
    private String contact;

}
