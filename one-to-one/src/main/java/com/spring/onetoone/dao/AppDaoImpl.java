package com.spring.onetoone.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.onetoone.entity.Instructor;
import com.spring.onetoone.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoImpl implements AppDAO {
	private EntityManager entityManager;

	@Autowired
	public AppDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
	}

	@Override
	public Instructor findInstructorById(int theId) {

		return entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void DeleteInstructorById(int theId) {
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);
		entityManager.remove(tempInstructor);
	}

	@Override
	public InstructorDetail findInstructorDetailsById(int theId) {

		return entityManager.find(InstructorDetail.class, theId);
	}

	@Override
	@Transactional
	public void DeleteInstructotDetailById(int theId) {
		InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
		// remove the associated object reference
		// break bi-directional link
		tempInstructorDetail.getInstructor().setInstructordetail(null);
		entityManager.remove(tempInstructorDetail);

	}

}
