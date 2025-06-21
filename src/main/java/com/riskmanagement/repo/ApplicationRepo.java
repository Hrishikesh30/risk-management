package com.riskmanagement.repo;

import com.riskmanagement.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepo extends JpaRepository<ApplicationEntity,Long> {
    List<ApplicationEntity> findByUserUserId(Long userId);
}
