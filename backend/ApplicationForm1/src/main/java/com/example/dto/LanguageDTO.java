package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDTO {
    @NotBlank private String language;
   private boolean read;
     private boolean write;
     private boolean speak;
}