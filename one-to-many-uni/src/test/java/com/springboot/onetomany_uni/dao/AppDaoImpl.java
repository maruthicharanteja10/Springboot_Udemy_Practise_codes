package com.springboot.onetomany_uni.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.springboot.onetomany_uni.entity.Course;
import com.springboot.onetomany_uni.entity.Instructor;
import com.springboot.onetomany_uni.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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

	@Override
	public List<Course> findCoursesByInstructorId(int theId) {
		Query query = entityManager.createQuery("select c from Course c where instructor.id=:data", Course.class);
		query.setParameter("data", theId);
		return query.getResultList();
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {
		TypedQuery<Instructor> query = entityManager.createQuery(
				"select i from Instructor i JOIN FETCH i.courses where instructor.id=:data", Instructor.class);
		query.setParameter("data", theId);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public void updateInstructor(Instructor tempInstructor) {
		entityManager.merge(tempInstructor);
	}

	@Override
	@Transactional
	public void updatCourse(Course tempCourse) {
		entityManager.merge(tempCourse);
	}

	@Override
	public Course findCourseById(int theId) {

		return entityManager.find(Course.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructor(int theId) {
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);
		List<Course> courses = tempInstructor.getCourses();
		for (Course tempCourse : courses) {
			tempCourse.setInstructor(null);
		}
		entityManager.remove(tempInstructor);

	}

	@Override
	@Transactional
	public void deleteCourse(int theId) {
		Course tempCourse = entityManager.find(Course.class, theId);
		entityManager.remove(tempCourse);
	}

	@Override
	@Transactional
	public void saveCourse(Course theCourse) {
		entityManager.persist(theCourse);
	}

	@Override
	public Course findCourseandReviewsByCourseId(int theId) {
		TypedQuery<Course> query = entityManager
				.createQuery("select c from Course c JOIN FETCH c.reviews where c.id=:data", Course.class);
		query.setParameter("data", theId);
		return query.getSingleResult();
	}

}
