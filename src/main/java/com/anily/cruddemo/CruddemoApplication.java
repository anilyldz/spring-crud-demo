package com.anily.cruddemo;

import com.anily.cruddemo.dao.StudentDAO;
import com.anily.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//listStudents(studentDAO);
			//listStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("Anil", "Yildiz", "anil.yildiz@mail.com");
		studentDAO.save(tempStudent);
		System.out.println("Student saved id : " + tempStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("Robert", "Oppenheimer", "robert.oppenheimer@mail.com");
		studentDAO.save(tempStudent);
		System.out.println("Student saved id : " + tempStudent.getId());

		Student myStudent = studentDAO.findbyId(tempStudent.getId());

		System.out.println("Finding Student : " + myStudent);
	}

	private void listStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void listStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Yildiz");
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 7;
		Student student = studentDAO.findbyId(studentId);
		student.setLastName("Kiyosaki");
		studentDAO.updateStudent(student);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 7;
		studentDAO.deleteStudent(studentId);
	}
}
