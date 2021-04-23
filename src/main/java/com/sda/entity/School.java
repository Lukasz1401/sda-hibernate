package com.sda.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "schools", fetch = FetchType.EAGER)
    Set<Student> students = new HashSet<>();

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.addSchool(this);
    }

    public String getName() {
        return name;
    }

    public Set<Student> getStudents() {
        return this.students;
    }
}
