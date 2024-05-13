package com.usercard.user.enities;

import jakarta.persistence.Column;

public class CategoryEntity {

    @Column(name = "name_category")
    private String nameCategory;

    @Column(name = "max_score")
    private Long maxScore;

    @Column(name = "archived")
    private Boolean archived;
}
