package com.navneet.learning.bms.bmsapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Setter
@Getter
@Slf4j
@NoArgsConstructor
@Entity
@ToString
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String role;

    public User(String name, String role) {
        super();
        this.name = name;
        this.role = role;
    }
}
