package com.usercard.user.enities;

import com.usercard.user.enities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Person")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "second_name")
    private String second_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "group_id")
    private Long group_id;

    @Column(name = "achievments")
    private String achievments;

    @Column(name = "login")
    private String login;

    @Column(name = "parol")
    private String parol;
}
