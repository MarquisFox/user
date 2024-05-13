package com.usercard.user.repo;

import com.usercard.user.enities.AchievementEntity;
import com.usercard.user.enities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findAll();
}
