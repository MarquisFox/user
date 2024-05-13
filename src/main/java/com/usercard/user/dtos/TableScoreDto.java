package com.usercard.user.dtos;

import com.usercard.user.enities.EventEntity;
import com.usercard.user.enities.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TableScoreDto {
    private Long id;

    private PersonDto person;

    private Long personId;

    private EventDto event;

    private Long eventId;

    private Long score;

    private LocalDateTime dateTime;

    private Boolean archived;
}
