package com.sda.entity;

import javax.persistence.*;

@Entity
public class Wife {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToOne(mappedBy = "wife", cascade = CascadeType.PERSIST)
    Husband husband;

    public Wife(String name) {
        this.name = name;
    }

    public Wife(String name, Husband husband) {
        this.name = name;
        this.husband = husband;
        husband.setWife(this);
    }

    public Wife() {
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        husband.setWife(this);
        this.husband = husband;
    }
}
