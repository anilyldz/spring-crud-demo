package com.anily.cruddemo;

import com.anily.cruddemo.dao.StudentDAO;
import com.anily.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			readStudent(studentDAO);
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

}
