package com.usercard.user.dtos;

import com.usercard.user.enities.GroupEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private Long id;

    private String first_name;

    private String second_name;

    private String last_name;

    private GroupDto group;

    private Long group_id;

    private String login;

    private String password;

    private String urlPhoto;

    private Boolean archived;
}
