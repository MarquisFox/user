package com.usercard.user.repo;

import com.usercard.user.enities.PersonEntity;
import com.usercard.user.enities.TableScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TableScoreRepo extends JpaRepository<TableScoreEntity, Long> {
    List<TableScoreEntity> findAll();
}
