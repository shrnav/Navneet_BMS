package com.navneet.learning.bms.bmsapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue
    private long addressId;
    @Column(name = "FULL_ADD")
    private String fullAdd;

    public Address() {
    }

    public Address(String fullAdd) {
        this.fullAdd = fullAdd;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getFullAdd() {
        return fullAdd;
    }

    public void setFullAdd(String fullAdd) {
        this.fullAdd = fullAdd;
    }
}
