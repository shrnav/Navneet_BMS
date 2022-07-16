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
@Table(name = "SCREEN")
public class Screen {
    @Id
    @Column(name = "SCREEN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long screenId;
    @Column(name = "THEATRE_ID")
    private long theatreId;
    @Column(name = "SEATS_NUM")

    private int seatsNum;

    public Screen(long theatreId, int seatsNum) {
        this.theatreId = theatreId;
        this.seatsNum = seatsNum;
    }
}
