package com.usercard.user.repo;

import com.usercard.user.enities.AchievementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementRepo extends JpaRepository<AchievementEntity, Long> {
    List<AchievementEntity> findAll();
}
