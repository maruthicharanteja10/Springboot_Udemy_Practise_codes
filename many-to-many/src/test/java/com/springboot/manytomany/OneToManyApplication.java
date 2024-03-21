package com.springboot.manytomany;

import java.util.List;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.manytomany.dao.AppDAO;
import com.springboot.manytomany.entity.Course;
import com.springboot.manytomany.entity.Instructor;
import com.springboot.manytomany.entity.InstructorDetail;
import com.springboot.manytomany.entity.Review;
import com.springboot.manytomany.entity.Student;

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

//			createCourseAndStudent(appDAO);
//			findCourseAndStudents(appDAO);
//			findStudentAndCourses(appDAO);
//			updateStudent(appDAO);
			deleteStudent(appDAO);
//			deleteCourse(appDAO);
		};

	}

	private void deleteStudent(AppDAO appDAO) {
		int id=1;
	
	System.out.println("Deleting student with id: "+id);
	
	appDAO.deleteStudent(id);
		
	}

	private void updateStudent(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get course ");
		int id = sc.nextInt();
		System.out.println("finding the course with id :" + id);
		Student tempStudent=appDAO.findstudentAndCoursesByStudentId(id);
		Course tempCourse1 = new Course("java programming");
		Course tempCourse2=new Course("python programming");
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		System.out.println("saving students :"+tempStudent);
		System.out.println("Associated courses : "+tempStudent.getCourses());
		appDAO.Update(tempStudent);
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get Instructor ");
		int id = sc.nextInt();
		System.out.println("Getting the courses for student with id :" + id);
		Student tempStudent = appDAO.findstudentAndCoursesByStudentId(id);
		System.out.println("student :" + tempStudent);
		System.out.println("the associated courses :" + tempStudent.getCourses());
		
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get students and courses ");
		int id = sc.nextInt();
		System.out.println("Getting the students for course with id :" + id);
		Course tempCourse = appDAO.findstudentsAndCourseByCourseId(id);
		System.out.println("courses :" + tempCourse);

		System.out.println("the associated students :" + tempCourse.getStudents());
	}

	private void createCourseAndStudent(AppDAO appDAO) {
		Course tempCourse = new Course("Software Development ");
		Student tempStudent1 = new Student("tej", "charan", "tej@gmail.com");
		Student tempStudent2 = new Student("maruthi", "charan", "tej@gmail.com");
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		System.out.println("course" + tempCourse);
		System.out.println("Students : " + tempCourse.getStudents());
		appDAO.saveCourse(tempCourse);

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting the course and reviews with Id :");
		appDAO.findCourseById(theId);

	}

	private void retrieveCoursesAndReviews(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get course ");
		int id = sc.nextInt();
		System.out.println("finding the course with id :" + id);
		Course tempCourse = appDAO.findCourseandReviewsByCourseId(id);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse = new Course("java programming-The new Beginner Course");
		tempCourse.addReview(new Review("Excellent for freshers to learn"));
		tempCourse.addReview(new Review("Easy to learn and Understand"));
		tempCourse.addReview(new Review("Good teaching  and Easily understandble"));
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.saveCourse(tempCourse);
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
		Course tempCourse = appDAO.findCourseById(id);
		System.out.println("Updating instructor with ID : " + id);
		tempCourse.setTitle("cloud computing");
		appDAO.updatCourse(tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id to get Instructor ");
		int id = sc.nextInt();
		System.out.println("finding the instructor with id :" + id);
		Instructor tempInstructor = appDAO.findInstructorById(id);
		System.out.println("Updating instructor with ID : " + id);
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
