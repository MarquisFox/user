package com.usercard.user.repo;

import com.usercard.user.enities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepo extends JpaRepository<PersonEntity, Long> {
    List<PersonEntity> findAll();
}
