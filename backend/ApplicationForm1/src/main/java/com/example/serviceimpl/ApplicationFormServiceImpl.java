package com.example.serviceimpl;
import com.example.model.*;
import com.example.dto.ApplicationFormDTO;
import com.example.mapper.ApplicationFormMapper;
import com.example.model.ApplicationForm;
import com.example.repository.ApplicationRepository;
import com.example.repository.UserRepository;
import com.example.service.ApplicationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.transaction.annotation.Transactional;
import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ApplicationFormServiceImpl implements ApplicationFormService {

    @Autowired
    private ApplicationRepository repository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationFormMapper mapper;
    @Override
    public ApplicationFormDTO getFormAsDTO(ApplicationForm form) {
        return mapper.entityToDto(form);
    }

    @Override
    @Transactional
    public ApplicationForm save(ApplicationFormDTO dto, MultipartFile photo, MultipartFile chart,User user) throws IOException {
        ApplicationForm form = new ApplicationForm();

    
        form.setFullName(dto.getFullName());
        form.setFatherName(dto.getFatherName());
        form.setEmail(dto.getEmail());
        form.setPhone(dto.getPhone());
        form.setGender(dto.getGender());
        form.setMaritalStatus(dto.getMaritalStatus());
        form.setDob(dto.getDob());
        form.setPanCard(dto.getPanCard());
        form.setNationality(dto.getNationality());
        form.setWillingToTravel(dto.getWillingToTravel());
        form.setHasVisa(dto.getHasVisa());
        form.setPlaceOfBirth(dto.getPlaceOfBirth());
        form.setDeclarationSignedBy(dto.getDeclarationSignedBy());
        form.setDeclarationDate(dto.getDeclarationDate());
        form.setAttendedInterviewIn6Months(dto.getAttendedInterviewIn6Months());
        form.setUser(user);

  
        if (photo != null && !photo.isEmpty()) {
            String photoName = UUID.randomUUID() + "_" + photo.getOriginalFilename();
            Path path = Paths.get("uploads/photos/" + photoName);
            Files.createDirectories(path.getParent());
            Files.write(path, photo.getBytes());
            form.setPhotoFilename(photoName);
        }

        if (chart != null && !chart.isEmpty()) {
            String chartName = UUID.randomUUID() + "_" + chart.getOriginalFilename();
            Path path = Paths.get("uploads/charts/" + chartName);
            Files.createDirectories(path.getParent());
            Files.write(path, chart.getBytes());
            form.setOrganizationChartFilename(chartName);
        }
        form.setPresentAddress(mapper.mapAddress(dto.getPresentAddress()));

        if (dto.getPermanentAddress() != null) {
            form.setPermanentAddress(mapper.mapAddress(dto.getPermanentAddress()));
        } else {
            
            form.setPermanentAddress(mapper.mapAddress(dto.getPresentAddress()));
        }

       
        form.setFamilyMembers(dto.getFamilyMembers().stream().map(f -> mapper.mapFamilyMember(f, form)).collect(Collectors.toList()));
        form.setLanguageProficiencies(dto.getLanguageProficiencies().stream().map(l -> mapper.mapLanguage(l, form)).collect(Collectors.toList()));
        form.setTrainings(dto.getTrainings().stream().map(t -> mapper.mapTraining(t, form)).collect(Collectors.toList()));
        form.setProjects(dto.getProjects().stream().map(p -> mapper.mapProject(p, form)).collect(Collectors.toList()));
        form.setReferees(dto.getReferees().stream().map(r -> mapper.mapReferee(r, form)).collect(Collectors.toList()));
        form.setEducationList(dto.getEducationList().stream().map(r -> mapper.mapEducation(r, form)).collect(Collectors.toList()));

        form.setPersonalAssessment(mapper.mapAssessment(dto.getPersonalAssessment(), form));;

  if (dto.getAdditionalQualifications() != null && !dto.getAdditionalQualifications().isEmpty())
            form.setAdditionalQualifications(dto.getAdditionalQualifications().stream().map(a -> mapper.mapAdditionalQualification(a, form)).collect(Collectors.toList()));

        if (dto.getPassportDetails() != null&& dto.getPassportDetails().getPassportNumber()!=null) {
            form.setPassportDetails(mapper.mapPassport(dto.getPassportDetails(), form));
        }
        if (dto.getGapExplanations() != null&& !dto.getGapExplanations().isEmpty()) {
            form.setGapExplanations(dto.getGapExplanations().stream().map(g -> mapper.mapGap(g, form)).collect(Collectors.toList()));
        }
        if (dto.getAchievements() != null && !dto.getAchievements().isEmpty()) {
            form.setAchievements(dto.getAchievements().stream().map(a -> mapper.mapAchievement(a, form)).collect(Collectors.toList()));
        }
        if (dto.getEmploymentHistories() != null && !dto.getEmploymentHistories() .isEmpty()) {
            form.setEmploymentHistories(dto.getEmploymentHistories().stream().map(e -> mapper.mapEmployment(e, form)).collect(Collectors.toList()));
        }
        return repository.save(form);
    }

    @Override
    @Transactional
    public ApplicationFormDTO updatePersonalAndAddress(ApplicationFormDTO dto, MultipartFile photo, MultipartFile chart, String email) throws IOException {

        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

        ApplicationForm form = user.getApplicationForm();
        if (form == null) {
            throw new RuntimeException("Form not found");
        }

     
        form.setFullName(dto.getFullName());
        form.setFatherName(dto.getFatherName());
        form.setEmail(dto.getEmail());
        form.setPhone(dto.getPhone());
        form.setGender(dto.getGender());
        form.setMaritalStatus(dto.getMaritalStatus());
        form.setDob(dto.getDob());
        form.setPanCard(dto.getPanCard());
        form.setNationality(dto.getNationality());
        form.setWillingToTravel(dto.getWillingToTravel());
        form.setHasVisa(dto.getHasVisa());
        form.setPlaceOfBirth(dto.getPlaceOfBirth());
        form.setDeclarationSignedBy(dto.getDeclarationSignedBy());
        form.setDeclarationDate(dto.getDeclarationDate());
        form.setAttendedInterviewIn6Months(dto.getAttendedInterviewIn6Months());

        if (dto.getPresentAddress() != null) {
            form.setPresentAddress(mapper.mapAddress(dto.getPresentAddress()));
        }

        if (dto.getPermanentAddress() != null) {
            form.setPermanentAddress(mapper.mapAddress(dto.getPermanentAddress()));
        }

       
        if (photo != null && !photo.isEmpty()) {
            String photoName = UUID.randomUUID() + "_" + photo.getOriginalFilename();
            Path path = Paths.get("uploads/photos/" + photoName);
            Files.createDirectories(path.getParent());
            Files.write(path, photo.getBytes());
            form.setPhotoFilename(photoName);
        }

        if (chart != null && !chart.isEmpty()) {
            String chartName = UUID.randomUUID() + "_" + chart.getOriginalFilename();
            Path path = Paths.get("uploads/charts/" + chartName);
            Files.createDirectories(path.getParent());
            Files.write(path, chart.getBytes());
            form.setOrganizationChartFilename(chartName);
        }

    
        form.getUser().setFormUpdated(true);

        ApplicationForm updated = repository.saveAndFlush(form);

        System.out.println("Final DB Save: " + updated.getFullName() + "  " + updated.getEmail());

        return getFormAsDTO(updated);
    }
}
