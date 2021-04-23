package com.sda.hibernate;

import com.sda.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main2PersistEntity {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(new Dog("Ares", 10, "Terier"));
        session.persist(new Dog("Reksio", 10, "Jamnik"));
        session.persist(new Dog("Burek", 10, "Buldog"));
        session.persist(new Dog("Misiek", 10, "Owczarek"));
        session.persist(new Dog("Astra", 10, "Jork"));


        transaction.commit();
        session.close();
    }
}
