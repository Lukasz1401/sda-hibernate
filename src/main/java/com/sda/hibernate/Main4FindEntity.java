package com.sda.hibernate;

import com.sda.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main4FindEntity {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dogOne = session.find(Dog.class, 1L);
        if (dogOne != null){
            System.out.println(dogOne.getId());
            System.out.println(dogOne.getName());
        }

        Dog dogTwo = session.get(Dog.class, 100L);
        if (dogTwo != null) {
            System.out.println(dogTwo.getId());
            System.out.println(dogTwo.getName());
        }

        Dog dogThree = session.load(Dog.class, 2L);
        if (dogThree != null) {
            System.out.println(dogThree.getId());
            System.out.println(dogThree.getName());
            System.out.println(dogThree.getRace());
        }

        transaction.commit();
        session.close();
    }
}
