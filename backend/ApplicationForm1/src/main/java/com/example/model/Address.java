package com.example.model;



import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	@Column(nullable=false)
    private String houseNo;
	@Column(nullable=false)
    private String city;
	@Column(nullable=false)
    private String state;
	@Column(nullable=false)
    private String pinCode;
	@Column(nullable=false)
    private String country;
	
}