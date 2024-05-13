package com.usercard.user.enities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class GroupEntity {

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
