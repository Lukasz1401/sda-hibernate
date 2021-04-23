package com.sda.hibernate;

import com.sda.entity.School;
import com.sda.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main13ManyToMany {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        School pg = new School("PG");
        School ug = new School("UG");

        Student jan = new Student("Jan");
        Student alicja = new Student("Alicja");
        Student mirek = new Student("Mirek");

        pg.addStudent(jan);
        pg.addStudent(alicja);

        ug.addStudent(alicja);
        ug.addStudent(mirek);

        session.persist(pg);
        session.persist(ug);

        transaction.commit();
        session.close();
    }
}
