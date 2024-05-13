package com.usercard.user.enities.base;

import jakarta.persistence.*;

public abstract class BaseEntity {
    public final static String PROP_ID = "id";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name="hibernate_sequence", sequenceName="hibernate_sequence", allocationSize=1)
    private Long id;
}
