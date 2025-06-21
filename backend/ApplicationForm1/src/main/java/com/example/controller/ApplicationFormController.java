package com.example.controller;



import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.config.JwtUtil;
import com.example.dto.ApplicationFormDTO;
import com.example.model.ApplicationForm;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.ApplicationFormService;
import java.util.*;
import io.jsonwebtoken.io.IOException;



@RestController
@RequestMapping("/api/application")
@CrossOrigin(origins ="http://localhost:4200")
public class ApplicationFormController {

    @Autowired
    private ApplicationFormService applicationFormService;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private JwtUtil jwtUtil;


    //   Submit Form (only once allowed)
    @PostMapping("/submit")
    public ResponseEntity<?> submitForm(
            @RequestPart("data") @Valid ApplicationFormDTO dto,
            @RequestPart(value = "photo", required = false) MultipartFile photo,
            @RequestPart(value = "chart", required = false) MultipartFile chart,
            @RequestHeader("Authorization") String authHeader) {

        try {
            String email = jwtUtil.extractEmail(authHeader.substring(7));
            User user = userRepo.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            if (user.isFormSubmitted()) {
                return ResponseEntity.badRequest().body(Map.of("message", "Form already submitted."));
            }

            ApplicationForm form = applicationFormService.save(dto, photo, chart, user);
            
        
            
            user.setApplicationForm(form);
            user.setFormSubmitted(true);
            user.setFormUpdated(false);
            userRepo.save(user);

            return ResponseEntity.ok(Map.of("message", "Form submitted successfully."));

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "File upload error: " + e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "Unexpected error: " + e.getMessage()));
        }
    }

    //  2. Get api
    @GetMapping("/my-form")
    public ResponseEntity<?> getMyForm(@RequestHeader("Authorization") String authHeader) {
        try {
            String email = jwtUtil.extractEmail(authHeader.substring(7));
            User user = userRepo.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User not found"));
                   
//            System.out.println(user.getApplicationForm());        

            ApplicationForm form = user.getApplicationForm();
            if (form == null) {
                return ResponseEntity.ok
                        (Map.of("formSubmitted", false,"formUpdated",false));
            }
         

            ApplicationFormDTO dto = applicationFormService.getFormAsDTO(form);
            dto.setFormSubmitted(user.isFormSubmitted());
            
            dto.setFormUpdated(user.isFormUpdated()); // frontend needs this

            return ResponseEntity.ok(dto);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "Error fetching form: " + e.getMessage()));
        }
    }

    //  3. Update Personal Info and Address 
    @PutMapping("/update-personal-address")
    public ResponseEntity<?> updatePersonalAndAddress(
            @RequestPart("data") @Valid ApplicationFormDTO dto,
            @RequestPart(value = "photo", required = false) MultipartFile photo,
            @RequestPart(value = "chart", required = false) MultipartFile chart,
            @RequestHeader("Authorization") String authHeader) {

        try {
      
            String email = jwtUtil.extractEmail(authHeader.substring(7));
            User user = userRepo.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            System.out.println(user.getEmail());
            if (!user.isFormSubmitted()) {
                return ResponseEntity.badRequest()
                        .body(Map.of("message", "Form not submitted yet."));
            }

            if (user.isFormUpdated()) {
                return ResponseEntity.badRequest()
                        .body(Map.of("message", "Form already updated."));
            }
        	System.out.println("bhxh"+dto.getFullName()+dto.getEmail());

           
            applicationFormService.updatePersonalAndAddress(dto, photo, chart, email);



            return ResponseEntity.ok(Map.of("message", "Form updated successfully."));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "Update failed: " + e.getMessage()));
        }
    }

}