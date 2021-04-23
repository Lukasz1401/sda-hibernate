package com.sda.hibernate;

import com.sda.entity.Employee;
import com.sda.entity.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class Main7Annotations {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //Employee employee = new Employee("Jan", "strongPassword", "123456789", 20, new Date(), Gender.MALE, "description");
        //session.persist(employee);
        Employee employee = session.load(Employee.class, 1L);
        System.out.println(employee.getName());
        System.out.println(employee.getDescription());


        transaction.commit();
        session.close();
    }

}
