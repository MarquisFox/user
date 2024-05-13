package com.usercard.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AchievementDto {
    private Long id;

    private String achievementName;

    private PersonDto person;

    private Long personId;

    private String urlPhoto;

    private Boolean archived;
}
