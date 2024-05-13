package com.usercard.user.repo;

import com.usercard.user.enities.AchievementEntity;
import com.usercard.user.enities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EventRepo extends JpaRepository<EventEntity, Long>{
    List<EventEntity> findAll();
}
