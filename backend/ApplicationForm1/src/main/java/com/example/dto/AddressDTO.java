package com.example.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    @NotBlank    private String houseNo;
    @NotBlank private String city;
    @NotBlank private String state;
    @NotBlank private String pinCode;
    @NotBlank  private String country;
}