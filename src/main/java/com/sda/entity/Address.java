package com.sda.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    String street;
    String city;

    public Address() {
    }

   public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
}
