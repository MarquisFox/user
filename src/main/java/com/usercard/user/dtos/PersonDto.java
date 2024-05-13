package com.usercard.user.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private Integer id;

    private String name;


    private String first_name;

    private String second_name;


    private String last_name;


    private Long group_id;


    private String achievments;


    private String login;


    private String parol;
}
