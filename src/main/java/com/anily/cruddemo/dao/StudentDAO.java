package com.anily.cruddemo.dao;

import com.anily.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findbyId(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);
}
