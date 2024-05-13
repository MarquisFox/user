package com.usercard.user.repo;

import com.usercard.user.enities.PersonEntity;
import com.usercard.user.enities.TableScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableScoreRepo extends JpaRepository<TableScoreEntity, Long> {
    List<TableScoreEntity> findAll();
}
