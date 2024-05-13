package com.usercard.user.enities;

import com.usercard.user.enities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "achievements")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AchievementEntity extends BaseEntity {

    @Column(name = "achievement_name")
    private String achievementName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    @Column(name = "person_id", insertable = false, updatable = false)
    private Long personId;

    @Column(name = "url_photo")
    private String urlPhoto;

    @Column(name = "archived")
    private Boolean archived;
}
