package com.usercard.user.repo;

import com.usercard.user.enities.EventEntity;
import com.usercard.user.enities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroupRepo extends JpaRepository<GroupEntity, Long> {
    List<GroupEntity> findAll();
}
