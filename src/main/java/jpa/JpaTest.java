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
		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		/*EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();*/
		try {
//			test.createUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		manager.close();
		System.out.println(".. done");
	}

	private void createUsers() {
		int numOfUsers = manager.createQuery("SELECT u FROM User u", User.class).getResultList().size();
		if (numOfUsers == 0) {
			manager.persist(new User("Dupont", "Corentin", "cdupont@test.fr"));
			manager.persist(new User("Dupond", "Lucien", "cdupont@test.fr"));
			manager.persist(new User("Dupomp", "Mick", "cdupont@test.fr"));
			manager.persist(new User("Dupon", "Arthur", "cdupont@test.fr"));
		}
	}


}
