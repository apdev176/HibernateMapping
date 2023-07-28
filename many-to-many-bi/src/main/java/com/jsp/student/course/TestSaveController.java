package com.jsp.student.course;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveController {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ap");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student student1=new Student();
		student1.setName("rahul");
		student1.setEmail("rahul@mail.com");
		Student student2=new Student();
		student2.setName("yash");
		student2.setEmail("yash@mail.com");
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
		
		student1.setCourses(courses);
		student2.setCourses(courses);
		
		ArrayList<Student> students=new ArrayList<>();
		students.add(student1);
		students.add(student2);
		
		
		c1.setStudents(students);
		c2.setStudents(students);
		c3.setStudents(students);
		
		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(c1);
		entityManager.persist(c2);
		entityManager.persist(c3);

		entityTransaction.commit();
		
		
	}
}
