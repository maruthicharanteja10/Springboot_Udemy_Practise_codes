package com.hibernate.cruddemo;

import java.util.List;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.hibernate.cruddemo.dao.StudentDAO;
import com.hibernate.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
		// commandlineRunner is from the spring boot framework
		// Executed after the spring beans have been loaded
		return runner -> {
//			System.out.println("Hello World!!!");// custom code
//			createStudent(studentDao);
			createMultipleStudents(studentDao);
//			readStudent(studentDao);
//			queryforStudent(studentDao);
//			queryforStudentByLastname(studentDao);
//			updatestudent(studentDao);
//			deleteStudent(studentDao);
//			deleteAllstudents(studentDao);
		};
	}

	private void deleteAllstudents(StudentDAO studentDao) {
		System.out.println("Deleting all students");
		int count = studentDao.deleteAll();
		System.out.println("Deleted students count : " + count);

	}

	private void deleteStudent(StudentDAO studentDao) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id of student to delete");
		int studentId = s.nextInt();
		System.out.println("deleting student with Id : " + studentId);
		Student mystudent = studentDao.findById(studentId);
		studentDao.delete(studentId);
		System.out.println("Deleted succesfully");

	}

	private void updatestudent(StudentDAO studentDao) {
		// retrieve student based on primary key
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id of student to update");
		int studentId = s.nextInt();
		System.out.println("Getting student with Id : " + studentId);
		Student mystudent = studentDao.findById(studentId);
		// change the first name
		System.out.println("Updating student....!");
		mystudent.setFirstname("raju");
		// update the student
		studentDao.update(mystudent);
		// display the first student
		System.out.println("Updated Student : " + mystudent);
	}

	private void queryforStudentByLastname(StudentDAO studentDao) {
		// get a listof students
		List<Student> thestudents = studentDao.findByLastname("teja");
		// display list of students
		for (Student s : thestudents) {
			System.out.println("Student ID : " + s.getId());
			System.out.println("Student Name :" + s.getFirstname() + " " + s.getLastname());
			System.out.println("Student Email : " + s.getEmail());
		}
	}

	private void queryforStudent(StudentDAO studentDao) {
		// get a listof students
		List<Student> thestudents = studentDao.findAll();
		// display list of students
		for (Student s : thestudents) {
			System.out.println("Student ID : " + s.getId());
			System.out.println("Student Name :" + s.getFirstname() + " " + s.getLastname());
			System.out.println("Student Email : " + s.getEmail());
		}
	}

	private void readStudent(StudentDAO studentDao) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id to retrieve the student details");
		int theid = s.nextInt();
		// retrieve student based on id: primary key
		System.out.println("Retrieving the student id : " + theid);
		Student mystudent = studentDao.findById(theid);
		// display student
		if (mystudent != null) {
			System.out.println("Student found");
			System.out.println("student Id : " + mystudent.getId());
			System.out.println("Student name : " + mystudent.getFirstname() + " " + mystudent.getLastname());
			System.out.println("student Email : " + mystudent.getEmail());
		} else {
			System.out.println("Student is not found...!");
		}
	}

	private void createMultipleStudents(StudentDAO studentDao) {
		// create the student objects
		System.out.println("Creating a student object.....!");
		Student tempstudent1 = new Student("cherry", "reddy", "reddy@gmail.com");
		Student tempstudent2 = new Student("virat", "kohli", "virat@gmail.com");
		Student tempstudent3 = new Student("sachin", "tendulkar", "sachin@gmail.com");

		// save the student objects
		System.out.println("saving the student....!");
		studentDao.save(tempstudent1);
		studentDao.save(tempstudent2);
		studentDao.save(tempstudent3);
	}

	private void createStudent(StudentDAO studentDao) {
		// create the student object
		System.out.println("Creating a student object.....!");
		Student tempstudent = new Student("charan", "teja", "tej@gmail.com");
		// save the student object
		System.out.println("saving the student....!");
		studentDao.save(tempstudent);
		// display id of the saved student
		System.out.println("saved student.Generated ID :" + tempstudent.getId());
	}
}
