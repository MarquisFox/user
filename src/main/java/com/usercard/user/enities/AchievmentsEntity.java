package com.usercard.user.enities;

import com.usercard.user.enities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Achievments")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AchievmentsEntity extends BaseEntity {
    @Column(name = "achievment_name")
    private String achievment_name;
}
