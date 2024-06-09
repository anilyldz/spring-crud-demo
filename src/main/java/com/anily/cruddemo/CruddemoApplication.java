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
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//listStudents(studentDAO);
			//listStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("Anil", "Yildiz", "anil.yildiz@mail.com");
		studentDAO.save(tempStudent);
		System.out.println("Student saved id : " + tempStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student1 = new Student("Anil", "Yildiz", "anil.yildiz@mail.com");
		Student student2 = new Student("Erdem", "Yildiz", "erdem.yildiz@mail.com");
		Student student3 = new Student("Ece", "Yildiz", "ece.yildiz@mail.com");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
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

	private void deleteAllStudents(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number of rows deleted : " + numRowsDeleted);
	}
}
