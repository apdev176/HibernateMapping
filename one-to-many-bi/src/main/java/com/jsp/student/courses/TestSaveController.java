package com.jsp.student.courses;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveController {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ap");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student student=new Student();
		student.setName("rahul");
		student.setEmail("rahul@mail.com");
		
		Student student2=new Student();
		student2.setName("ap");
		student2.setEmail("ap@mail.com");
		
		Course c1=new Course();
		c1.setCname("computer");
		Course c2=new Course();
		c2.setCname("It");
		Course c3=new Course();
		c3.setCname("Electric");
		
		c1.setStudent(student);
		c2.setStudent(student);
		c3.setStudent(student);
		
		ArrayList<Course> courses=new ArrayList<>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		
		student.setCourses(courses);
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(student2);
		entityTransaction.commit();		

	}

}
