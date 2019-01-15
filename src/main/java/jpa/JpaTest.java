package jpa;

import metier.*;

import javax.persistence.*;
import java.util.List;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
//			test.createEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

//		test.listEmployees();

		manager.close();
		System.out.println(".. done");
	}




}
