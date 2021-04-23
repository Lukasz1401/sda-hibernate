package com.sda.hibernate;

import com.sda.entity.Husband;
import com.sda.entity.Wife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main9OneToOne {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

       // Husband adam = new Husband("Wojtek");
        //Wife ewa = new Wife("Aneta");

        //session.persist(adam);
        //session.persist(ewa);

        //adam.setWife(ewa);
        //ewa.setHusband(adam);

        session.persist(new Husband("Damian", new Wife("Anna")));
        session.persist(new Husband("Mariusz", new Wife("Wioleta")));
        session.persist(new Husband("Darek", new Wife("Judyta")));

        transaction.commit();
        session.close();
    }
}
