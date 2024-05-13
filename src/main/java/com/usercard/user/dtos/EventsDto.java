package com.usercard.user.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventsDto {
    private Integer id;

    private String name;

    private String description;

    private String place;

    public Boolean archived;
}
