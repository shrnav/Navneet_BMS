package com.navneet.learning.bms.bmsapi.entity;

import javax.persistence.*;

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

    public Screen() {
    }

    public long getScreenId() {
        return screenId;
    }

    public void setScreenId(long screenId) {
        this.screenId = screenId;
    }

    public long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(long theatreId) {
        this.theatreId = theatreId;
    }

    public int getSeatsNum() {
        return seatsNum;
    }

    public void setSeatsNum(int seatsNum) {
        this.seatsNum = seatsNum;
    }
}
