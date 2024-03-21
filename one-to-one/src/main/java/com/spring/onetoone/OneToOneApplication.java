package com.spring.onetoone;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.onetoone.dao.AppDAO;
import com.spring.onetoone.entity.Instructor;
import com.spring.onetoone.entity.InstructorDetail;

@SpringBootApplication
public class OneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
//		public CommandLineRunner commandLineRunner(String[] args) {
		// From the springbootFramework
		// Executed after Spring beans have been loaded
		return runner -> {
//			System.out.println("Hello World...!");
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			DeleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
			DeleteInstructorDetail(appDAO);
		};

	}

	private void DeleteInstructorDetail(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to delete Instructor Details");
		int id = sc.nextInt();
		System.out.println("deleting the instructor Detail:" + id);
		appDAO.DeleteInstructotDetailById(id);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get Instructor ");
		int id = sc.nextInt();
		System.out.println("Getting the InstructorDetails with id :" + id);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailsById(id);
		System.out.println("tempInstructor" + tempInstructorDetail);
		System.out.println("the associated InstructorDetail" + tempInstructorDetail.getInstructor());
	}

	private void DeleteInstructor(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to delete Instructor Details");
		int id = sc.nextInt();
		System.out.println("deleting the instructor :" + id);
		appDAO.DeleteInstructorById(id);

	}

	private void findInstructor(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get Instructor Details");
		int id = sc.nextInt();
		System.out.println("finding the instructor :" + id);
		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("tempInstructor" + tempInstructor);
		System.out.println("the associated InstructorDetail" + tempInstructor.getInstructordetail());

	}

	public void createInstructor(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("virat", "kohli", "virat@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.hindimovies.com", "watching movies");
		tempInstructor.setInstructordetail(tempInstructorDetail);
		System.out.println("saving instructor :" + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");
	}

}
