package com.sda.hibernate;

import com.sda.entity.Husband;
import com.sda.entity.Wife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main11OrphanRemoval {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Husband husband = session.find(Husband.class,5L);
        Wife wife = new Wife("Angelika");

        husband.setWife(wife);

        session.persist(wife);

        transaction.commit();
        session.close();
    }
}
