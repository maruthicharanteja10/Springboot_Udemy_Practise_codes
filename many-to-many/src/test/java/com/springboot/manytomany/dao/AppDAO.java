package com.springboot.manytomany.dao;

import java.util.List;

import com.springboot.manytomany.entity.Course;
import com.springboot.manytomany.entity.Instructor;
import com.springboot.manytomany.entity.InstructorDetail;
import com.springboot.manytomany.entity.Student;

public interface AppDAO {
	void save(Instructor theInstructor);

	Instructor findInstructorById(int theId);

	void DeleteInstructorById(int theId);

	InstructorDetail findInstructorDetailsById(int theId);

	void DeleteInstructotDetailById(int theId);

	List<Course> findCoursesByInstructorId(int theId);

	Instructor findInstructorByIdJoinFetch(int theId);

	void updateInstructor(Instructor tempInstructor);

	void updatCourse(Course tempCourse);

	Course findCourseById(int theId);

	void deleteInstructor(int theId);

	void deleteCourse(int theId);

	void saveCourse(Course theCourse);

	Course findCourseandReviewsByCourseId(int theId);

	Course findstudentsAndCourseByCourseId(int theId);

	Student findstudentAndCoursesByStudentId(int theId);
	
	void Update(Student theStudent);
	
	void deleteStudent(int theid);
}
