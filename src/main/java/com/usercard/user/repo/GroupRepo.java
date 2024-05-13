package com.usercard.user.repo;

import com.usercard.user.enities.EventEntity;
import com.usercard.user.enities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepo extends JpaRepository<GroupEntity, Long> {
    List<GroupEntity> findAll();
}
