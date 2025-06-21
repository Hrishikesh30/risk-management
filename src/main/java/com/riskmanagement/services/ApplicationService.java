package com.riskmanagement.services;

import com.riskmanagement.entity.ApplicationEntity;
import com.riskmanagement.repo.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private final ApplicationRepo applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepo applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    // Save or update application
    public ApplicationEntity submitApplication(ApplicationEntity application) {
        application.setSubmittedAt(LocalDateTime.now());
        application.setLastUpdatedAt(LocalDateTime.now());
        application.setStatus("SUBMITTED"); // default status
        return applicationRepository.save(application);
    }

    // Get all applications (for admin/reviewer)
    public List<ApplicationEntity> getAllApplications() {
        return applicationRepository.findAll();
    }

    // Get all applications submitted by a specific user
    public List<ApplicationEntity> getApplicationsByUserId(Long userId) {
        return applicationRepository.findByUserUserId(userId);
    }

    // Get a specific application by ID
    public Optional<ApplicationEntity> getApplicationById(Long applicationId) {
        return applicationRepository.findById(applicationId);
    }

    // Delete an application
    public void deleteApplication(Long applicationId) {
        applicationRepository.deleteById(applicationId);
    }
}
