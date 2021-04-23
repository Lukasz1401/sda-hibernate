package com.sda.entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    Set<Book> books = new HashSet<>();

    public Client() {
    }

    public Client(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setClient(this);
    }
}
