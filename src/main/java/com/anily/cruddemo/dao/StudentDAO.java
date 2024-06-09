package com.anily.cruddemo.dao;

import com.anily.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findbyId(Integer id);
}
