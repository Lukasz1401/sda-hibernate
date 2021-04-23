package com.sda.hibernate;

import com.sda.entity.School;
import com.sda.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Set;

public class Main14FetchType {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        School school = session.find(School.class, 1L);
        System.out.println(school.getName());

        Set<Student> students = school.getStudents();

        students.stream()
                .map(Student::getName)
                .forEach(System.out::println);

        transaction.commit();
        session.close();
    }
}
