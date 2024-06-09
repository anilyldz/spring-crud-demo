package com.anily.cruddemo.dao;

import com.anily.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findbyId(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //Student is the name of JPA entity not the database table
        TypedQuery<Student> findAllQuery = entityManager.createQuery("FROM Student", Student.class);
        return findAllQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //JPQL named parameters are prefixed with a ":"
        TypedQuery<Student> findByLastNameQuery = entityManager.createQuery("FROM Student WHERE lastName =:theData", Student.class);
        findByLastNameQuery.setParameter("theData", theLastName);
        return findByLastNameQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        Student studentToBeDeleted = entityManager.find(Student.class, id);
        entityManager.remove(studentToBeDeleted);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
