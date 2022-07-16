package com.navneet.learning.bms.bmsapi.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;

@Setter
@Getter
@Slf4j
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "ADDRESS")
public class Address {
    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue
    private long addressId;
    @Column(name = "FULL_ADD")
    @NonNull
    private String fullAdd;

    }

