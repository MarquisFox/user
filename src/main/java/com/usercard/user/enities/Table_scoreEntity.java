package com.usercard.user.enities;

import com.usercard.user.enities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Table_score")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Table_scoreEntity extends BaseEntity {
    @Column(name = "score")
    private Long score;
}