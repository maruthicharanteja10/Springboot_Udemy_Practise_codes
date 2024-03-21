package com.hibernate.cruddemo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.hibernate.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
	// define field for Entity Manager
	private EntityManager entityManager;

	// inject entity manager using constructor injection
	public StudentDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	// implement save method
	@Override
	@Transactional // we are performing an update
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// create query
		TypedQuery<Student> thequery = entityManager.createQuery("From Student", Student.class);
		// return query results
		return thequery.getResultList();
	}

	@Override
	public List<Student> findByLastname(String thelastname) {
		// create query
		TypedQuery<Student> thequery = entityManager.createQuery("From Student where lastname=:theData", Student.class);
		// set query parameters
		thequery.setParameter("theData", thelastname);
		// return query results
		return thequery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student thestudent) {
		entityManager.merge(thestudent);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// retrieve the student
		Student thestudent = entityManager.find(Student.class, id);
		// delete the student
		entityManager.remove(thestudent);
	}

	@Override
	@Transactional
	public int deleteAll() {
		int rowsdeleted = entityManager.createQuery("delete From Student").executeUpdate();
		return rowsdeleted;
	}

}
