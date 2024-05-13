package com.usercard.user.enities;

import com.usercard.user.enities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "institute")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstituteEntity extends BaseEntity {

    @Column(name = "adress")
    private String adress;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "archived")
    private Boolean archived;
}
