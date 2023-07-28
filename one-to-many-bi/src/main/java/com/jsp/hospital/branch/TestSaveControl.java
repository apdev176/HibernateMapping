package com.jsp.hospital.branch;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveControl {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ap");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital hospital = new Hospital();
		hospital.setHname("FORTIS");
		hospital.setGst("FORTIS1234567890");

		Branch b1 = new Branch();
		b1.setCity("Mumbai");
		Branch b2 = new Branch();
		b2.setCity("Navi Mumbai");
		Branch b3 = new Branch();
		b3.setCity("Bangalore");
      
		
		b1.setHospital(hospital);
		b2.setHospital(hospital);
		b3.setHospital(hospital);
		
		ArrayList<Branch> branches=new ArrayList<>();
		branches.add(b1);
		branches.add(b2);
		branches.add(b3);
		
		hospital.setBranches(branches);
		

		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(b1);
		
		entityManager.persist(b2);
		entityManager.persist(b3);

		entityTransaction.commit();

	}

}
