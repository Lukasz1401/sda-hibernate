package com.sda.hibernate;

import com.sda.entity.Husband;
import com.sda.entity.Wife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main15HQL {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Husband> queryOne = session.createQuery("SELECT h FROM Husband AS h ", Husband.class);
        List<Husband> resultList = queryOne.getResultList();
        resultList.stream().map(Husband::getName).forEach(System.out::println);

        Query<String> queryTwo = session.createQuery("SELECT h.name FROM Husband AS h", String.class);
        List<String> resultListTwo = queryTwo.getResultList();
        resultListTwo.forEach(System.out::println);

        System.out.println("---");

        Query<Wife> queryThree = session.createQuery("SELECT h.wife FROM Husband AS h", Wife.class);
        List<Wife> resultListThree = queryThree.getResultList();
        resultListThree.stream().map(Wife::getName).forEach(System.out::println);

        /* Query<Husband> queryFour = session.createQuery("SELECT h FROM Husband AS h WHERE h.id = :id", Husband.class);
        queryFour.setParameter("id", 4L);
        Husband singleResult = queryFour.getSingleResult();
        System.out.println("Imie meza: " + singleResult.getName()); */

        // Modyfikacja poprzedniego sposobu
        Husband singleResult = session.createQuery("SELECT h FROM Husband AS h WHERE h.id = :id", Husband.class)
                .setParameter("id", 4L)
                .getSingleResult();
        System.out.println("Imie meza: " + singleResult.getName());


        session.createQuery("SELECT w.name FROM Husband AS h INNER JOIN h.wife AS w", String.class)
                .getResultList()
                .forEach(System.out::println);

        transaction.commit();
        session.close();
    }
}
