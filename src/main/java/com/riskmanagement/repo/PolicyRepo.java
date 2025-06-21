package com.riskmanagement.repo;

import com.riskmanagement.entity.PolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepo extends JpaRepository<PolicyEntity, Long> {}
