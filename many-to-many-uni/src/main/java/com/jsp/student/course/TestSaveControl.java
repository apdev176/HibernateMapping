package com.jsp.student.course;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ap");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student student=new Student();
		student.setName("rahul");
		student.setEmail("rahul@mail.com");
		Course c1=new Course();
		c1.setSubject("science");
		c1.setDuration(7);
		Course c2=new Course();
		c2.setSubject("math");
		c2.setDuration(10);
		Course c3=new Course();
		c3.setSubject("history");
		c3.setDuration(9);
		
		ArrayList<Course> courses=new ArrayList<>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		
		student.setCourses(courses);
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(c1);
		
		entityManager.persist(c2);
		entityManager.persist(c3);

		entityTransaction.commit();
		
		
	}

}
