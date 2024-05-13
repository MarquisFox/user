package com.usercard.user.enities;

import com.usercard.user.enities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "table_score")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TableScoreEntity extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    @Column(name = "person_id", insertable = false, updatable = false)
    private Long personId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private EventEntity event;

    @Column(name = "event_id", insertable = false, updatable = false)
    private Long eventId;

    @Column(name = "score")
    private Long score;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "archived")
    private Boolean archived;
}