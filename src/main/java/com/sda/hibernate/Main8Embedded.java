package com.sda.hibernate;

import com.sda.entity.Address;
import com.sda.entity.Employee;
import com.sda.entity.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class Main8Embedded {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //todo

        //Employee employee = new Employee("Lukasz", "password", "313222444", 20, new Date(), Gender.MALE, "description");
        //employee.setAddress(new Address("Drzymaly", "Wroclaw"));

        //session.persist(employee);
        session.persist(new Employee("Wiesiek", "password1", "313224444", 30, new Date(), Gender.FAMALE, "description"));

        transaction.commit();
        session.close();
    }
}
