package com.jsp.person.adhar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestController {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("ap");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person=new Person();
		person.setName("sma");
		person.setEmail("sma@mail.com");
		
		Aadhar aadhar=new Aadhar();
		aadhar.setAadhar_no("1234567890");
		aadhar.setCity("mumbai");
		
		Aadhar aadhar2=new Aadhar();
		aadhar2.setAadhar_no("0987654321");
		aadhar2.setCity("pune");
		
		aadhar.setPerson(person);
		
		entityTransaction.begin();
		entityManager.persist(person);
        entityManager.persist(aadhar);
        entityManager.persist(aadhar2);
        entityTransaction.commit();
	}

}
