package com.navneet.learning.bms.bmsapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;

@Setter
@Getter
@Slf4j
@NoArgsConstructor
@Entity
@Table(name = "SEAT")
public class Seat {
    @Id
    @Column(name = "SEAT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seat_id;
    @Column(name = "ROW_ID")
    private char row_id;
    @Column(name = "ROW_NUMBER")
    private int row_number;
    @Column(name = "SCREEN_ID")
    private long screen_id;
}
