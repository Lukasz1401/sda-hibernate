package com.sda.hibernate;

import com.sda.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;

public class Main6DeleteEntity {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Dog dogOne = new Dog();
            dogOne.setId(2L);
            session.delete(dogOne);
            transaction.commit();
        }catch (OptimisticLockException e) {
            System.out.println("Krotka o podanym id nie istnieje");
            transaction.rollback();
        }
        session.close();
    }
}
