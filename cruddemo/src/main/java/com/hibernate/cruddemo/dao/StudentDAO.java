package com.hibernate.cruddemo.dao;

import java.util.List;
import com.hibernate.cruddemo.entity.Student;

public interface StudentDAO {
	void save(Student theStudent);

	Student findById(Integer id);

	List<Student> findAll();

	List<Student> findByLastname(String thelastname);

	void update(Student thestudent);

	void delete(Integer id);

	int deleteAll();
}
