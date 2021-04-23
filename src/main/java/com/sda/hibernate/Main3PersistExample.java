package com.sda.hibernate;

import com.sda.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main3PersistExample {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog = new Dog("Azor", 6, "Husky");

        System.out.println("---> ID:" + dog.getId());
        session.persist(dog); //azor, 6 , husky
        System.out.println("---> ID: " + dog.getId());

        dog.setRace("Kundel"); //azor, 6, kundel

        session.evict(dog);
        dog.setAge(7);

        transaction.commit(); // dirty checking
        session.close();
    }
}
