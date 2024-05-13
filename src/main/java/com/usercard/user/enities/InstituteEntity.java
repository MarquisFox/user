package com.usercard.user.enities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Institute")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstituteEntity {
    private String name;
}
