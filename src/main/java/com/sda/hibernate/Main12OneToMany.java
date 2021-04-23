package com.sda.hibernate;

import com.sda.entity.Book;
import com.sda.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main12OneToMany {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Client client = new Client("Lukasz");
        client.addBook(new Book("Ogniem i mieczem"));
        client.addBook(new Book("Pan Tadeusz"));
        client.addBook(new Book("Władca pierścieni"));
        client.addBook(new Book("Hobbit"));
        client.addBook(new Book("Harry Potter"));

        session.persist(client);

        transaction.commit();
        session.close();
    }
}
