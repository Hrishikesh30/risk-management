package com.riskmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "policies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;

    @Column(name = "policy_name", nullable = false, unique = true)
    private String policyName;     // "annualRevenue", "hasLawsuits"
    @Column(name = "rule_type", nullable = false)
    private String ruleType;      //  "MIN_VALUE", "MAX_VALUE", "EQUALS", "BOOLEAN_CHECK", "BETWEEN"
    private String description;
    private String expectedValue; // Used for EQUALS or BOOLEAN_CHECK (e.g., "false")
    private Double minValue;      // Used for MIN_VALUE, BETWEEN
    private Double maxValue;      // Used for MAX_VALUE, BETWEEN
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;    //checking policy is active or not
}
