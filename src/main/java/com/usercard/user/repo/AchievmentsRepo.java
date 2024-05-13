package com.usercard.user.repo;

import com.usercard.user.enities.AchievmentsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievmentsRepo extends CrudRepository<AchievmentsEntity, Long> {
    List<AchievmentsEntity> findAll();
}
