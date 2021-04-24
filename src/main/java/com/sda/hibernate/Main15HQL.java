package com.sda.hibernate;

import com.sda.entity.Husband;
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

        Query<String> queryTwo = session.createQuery("SELET h.name FROM Husband AS h", String.class);
        List<String> resultListTwo = queryTwo.getResultList();
        resultListTwo.forEach(System.out::println);

        transaction.commit();
        session.close();
    }
}
