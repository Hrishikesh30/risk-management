package com.riskmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationId;

    @Column(name="company_id")
    private Long companyId;

    // Applicant Details
    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName = "userId",nullable = false)
    private UserEntity user;

    // Financial Inputs (updated)
    private BigDecimal financialConditionRatio;
    private BigDecimal netIncome;
    private BigDecimal debtRatio;
    private BigDecimal loanAmount;
    private BigDecimal loanToValueRatio;
    private Boolean currentLegalAction;
    private Integer creditScore;

    // Other Company Info (retained)
    private String industry;
    private String geographicalLocation;
    private Boolean hasLawsuits;
    private Boolean hasLiens;

    // Status & Decision
    private String status;         // SUBMITTED, UNDER_REVIEW, APPROVED, REJECTED

    private LocalDateTime submittedAt;
    private LocalDateTime lastUpdatedAt;
}
