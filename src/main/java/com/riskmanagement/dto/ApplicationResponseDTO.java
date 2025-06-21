package com.riskmanagement.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ApplicationResponseDTO {
    private Long applicationId;
    private Long companyId;
    private Long userId;
    private String userName;
    private String status;
    private LocalDateTime submittedAt;


//    private BigDecimal financialConditionRatio;
//    private BigDecimal loanAmount;

}
