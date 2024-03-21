package com.spring.onetoone.dao;

import com.spring.onetoone.entity.Instructor;
import com.spring.onetoone.entity.InstructorDetail;

public interface AppDAO {
	void save(Instructor theInstructor);

	Instructor findInstructorById(int theId);

	void DeleteInstructorById(int theId);

	InstructorDetail findInstructorDetailsById(int theId);
	
	void DeleteInstructotDetailById(int theId);
}
