package com.usercard.user.enities;

import com.usercard.user.enities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "events")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity extends BaseEntity {
    @Column(name = "name_event")
    private String nameEvent;

    @Column(name = "description")
    private String description;

    @Column(name = "place")
    private String place;

    @Column(name = "archived")
    public Boolean archived;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "url")
    private String url;

    @Column(name = "url_photo")
    private String urlPhoto;

    @Column(name = "score")
    private Long score;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Column(name = "category_id", insertable = false, updatable = false)
    private Long categoryId;

}
