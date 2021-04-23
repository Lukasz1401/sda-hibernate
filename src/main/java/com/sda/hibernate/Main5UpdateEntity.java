package com.sda.hibernate;

import com.sda.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main5UpdateEntity {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog = new Dog();
        dog.setId(1L);
        dog.setAge(20);
        dog.setRace("Chiuaua");
        dog.setName("Ares");

        session.update(dog);

        transaction.commit();
        session.close();
    }
}
