package com.usercard.user.dtos;


import com.usercard.user.enities.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private Long id;

    private String nameEvent;

    private String description;

    private String place;

    public Boolean archived;

    private LocalDateTime dateTime;

    private String url;

    private String urlPhoto;

    private Long score;

    private CategoryDto category;

    private Long categoryId;
}
