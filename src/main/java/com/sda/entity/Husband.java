package com.sda.entity;

import javax.persistence.*;

@Entity
public class Husband {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "my_wife_id")
    Wife wife;

    public Husband(String name) {
        this.name = name;
    }

    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }

    public Husband() {
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
