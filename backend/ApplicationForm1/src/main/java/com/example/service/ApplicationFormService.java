package com.example.service;


import org.springframework.web.multipart.MultipartFile;

import com.example.dto.ApplicationFormDTO;
import com.example.model.ApplicationForm;
import com.example.model.User;

import java.io.IOException;

public interface ApplicationFormService {
    ApplicationForm save(ApplicationFormDTO dto, MultipartFile photo, MultipartFile chart, User user) throws IOException;
    ApplicationFormDTO getFormAsDTO(ApplicationForm form);
	ApplicationFormDTO updatePersonalAndAddress(ApplicationFormDTO dto, MultipartFile photo, MultipartFile chart,
			String email) throws IOException;
}