package com.usercard.user.repo;

import com.usercard.user.enities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonRepo extends JpaRepository<PersonEntity, Long> {
    List<PersonEntity> findAll();

    @Query(value = "select p.*\n" +
            "from person p\n" +
            "join \"group\" gr on p.group_id = gr.id\n" +
            "join institute i on gr.institute_id = i.id\n" +
            "where LOWER(gr.name_group) LIKE LOWER('%:groupName%')\n" +
            "and\n" +
            "LOWER(i.name) LIKE LOWER('%:instituteName%')", nativeQuery = true)
    PersonEntity findByFilter (@Param("groupName") String groupName, @Param("instituteName") String instituteName);
}
