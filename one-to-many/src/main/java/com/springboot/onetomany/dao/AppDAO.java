package com.springboot.onetomany.dao;

import java.util.List;

import com.springboot.onetomany.entity.Course;
import com.springboot.onetomany.entity.Instructor;
import com.springboot.onetomany.entity.InstructorDetail;

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
}
