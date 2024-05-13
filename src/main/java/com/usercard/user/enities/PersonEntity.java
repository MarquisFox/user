package com.usercard.user.enities;

import com.usercard.user.enities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "person")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity extends BaseEntity {

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "second_name")
    private String second_name;

    @Column(name = "last_name")
    private String last_name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @Column(name = "group_id", insertable = false, updatable = false)
    private Long groupId;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "url_photo")
    private String urlPhoto;

    @Column(name = "archived")
    private Boolean archived;
}
