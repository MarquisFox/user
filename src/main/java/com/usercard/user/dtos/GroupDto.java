package com.usercard.user.dtos;

import com.usercard.user.enities.InstituteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

    private Long id;

    private InstituteDto institute;

    private Long instituteId;

    private String nameGroup;

    private Boolean archived;
}
