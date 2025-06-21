package com.riskmanagement.controller;

import com.riskmanagement.dto.ApplicationResponseDTO;
import com.riskmanagement.entity.ApplicationEntity;
import com.riskmanagement.entity.CompanyEntity;
import com.riskmanagement.entity.UserEntity;
import com.riskmanagement.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    // Submit application
    @PostMapping("/submit")
    public ResponseEntity<ApplicationResponseDTO> submitApplication(
            @RequestBody ApplicationEntity application,
            @RequestParam Long userId,
            @RequestParam Long companyId
    ) {
        // Temporary manual user reference setup
        UserEntity user = new UserEntity();
        user.setUserId(userId);
        application.setUser(user);

        CompanyEntity company = new CompanyEntity();
        company.setCompanyId(companyId);
        application.setCompany(company);

        ApplicationEntity savedApplication = applicationService.submitApplication(application);
        ApplicationResponseDTO responseDTO= new ApplicationResponseDTO();
        responseDTO.setApplicationId(savedApplication.getApplicationId());
        responseDTO.setUserId(savedApplication.getUser().getUserId());
        responseDTO.setCompanyId(savedApplication.getCompany().getCompanyId());
        responseDTO.setStatus(savedApplication.getStatus());
        responseDTO.setUserName(savedApplication.getUser().getUsername());
        responseDTO.setSubmittedAt(savedApplication.getSubmittedAt());
        return ResponseEntity.ok(responseDTO);
    }
}
