package com.springboot.onetomany;

import java.util.List;


import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.onetomany.dao.AppDAO;
import com.springboot.onetomany.entity.Course;
import com.springboot.onetomany.entity.Instructor;
import com.springboot.onetomany.entity.InstructorDetail;




@SpringBootApplication
public class OneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
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
//			DeleteInstructorDetail(appDAO);
//			createInstructorwithCourses(appDAO);
//			findInstructorWithCourses(appDAO);
//			findcoursesforInstructot(appDAO);
//			findInstructorWithCoursesJoinFetch(appDAO);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
//			deleteInstructor(appDAO);
			deleteCourse(appDAO);
		};

	}

	private void deleteCourse(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get course ");
		int id = sc.nextInt();
		System.out.println("finding the course with id :" + id);
		appDAO.deleteCourse(id);
		
	}

	private void deleteInstructor(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get course ");
		int id = sc.nextInt();
		System.out.println("finding the instructor with id :" + id);
		appDAO.deleteInstructor(id);
	}

	private void updateCourse(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get course ");
		int id = sc.nextInt();
		System.out.println("finding the course with id :" + id);
		Course tempCourse=appDAO.findCourseById(id);
		System.out.println("Updating instructor with ID : "+id);
		tempCourse.setTitle("cloud computing");
		appDAO.updatCourse(tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get Instructor ");
		int id = sc.nextInt();
		System.out.println("finding the instructor with id :" + id);
		Instructor tempInstructor=appDAO.findInstructorById(id);
		System.out.println("Updating instructor with ID : "+id);
		tempInstructor.setLast_name("reddy");
		appDAO.updateInstructor(tempInstructor);
		
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get Instructor ");
		int id = sc.nextInt();
		System.out.println("Getting the courses for instructor with id :" + id);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println("instructor :" + tempInstructor);
		System.out.println("the associated courses :" + tempInstructor.getCourses());
	}

	private void findcoursesforInstructot(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get Instructor ");
		int id = sc.nextInt();
		System.out.println("Getting the courses for instructor with id :" + id);
		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("instructor :" + tempInstructor);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		tempInstructor.setCourses(courses);
		System.out.println("the associated courses :" + tempInstructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get Instructor ");
		int id = sc.nextInt();
		System.out.println("Getting the instructor with id :" + id);
		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("instructor :" + tempInstructor);
		System.out.println("the associated courses :" + tempInstructor.getCourses());
	}

	private void createInstructorwithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("cherry", "maruthi", "maruthi@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.hindimovies.com", "watching movies");
		tempInstructor.setInstructordetail(tempInstructorDetail);
		Course tempCourse1 = new Course("java programming");
		Course tempCourse2 = new Course("python programming");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		System.out.println("saving instructor :" + tempInstructor);
		System.out.println("saving courses" + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done");

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
