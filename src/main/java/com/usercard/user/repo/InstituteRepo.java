package com.usercard.user.repo;

import com.usercard.user.enities.EventEntity;
import com.usercard.user.enities.InstituteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstituteRepo extends JpaRepository<InstituteEntity, Long> {
    List<InstituteEntity> findAll();
}
