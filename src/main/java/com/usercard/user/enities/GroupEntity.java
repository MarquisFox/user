package com.usercard.user.enities;

import com.usercard.user.enities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "group")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupEntity extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "institute_id")
    private  InstituteEntity  institute;

    @Column(name = "institute_id", insertable = false, updatable = false)
    private Long instituteId;

    @Column(name = "name_group")
    private String nameGroup;

    @Column(name = "archived")
    private Boolean archived;
}
