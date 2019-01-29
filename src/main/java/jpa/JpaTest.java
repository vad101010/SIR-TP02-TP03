package jpa;

import entity.*;

import javax.persistence.*;
import java.util.List;

public class JpaTest
{

    private EntityManager manager;

    public JpaTest(EntityManager manager)
    {
        this.manager = manager;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        JpaTest test = new JpaTest(manager);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try
        {
            test.createUser();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        tx.commit();

        System.out.println("nombre de user trouvé :" + test.getUser("dupon%").size());
        manager.close();
        System.out.println(".. done");
    }

    private void createUser()
    {
        int numOfUsers = manager.createQuery("SELECT u FROM User u", User.class).getResultList().size();
        if (numOfUsers == 0)
        {
            manager.persist(new User("Dupont", "Corentin", "cdupont@test.fr"));
            manager.persist(new User("Dupond", "Lucien", "cdupont@test.fr"));
            manager.persist(new User("Dupomp", "Mick", "cdupont@test.fr"));
            manager.persist(new User("Dupon", "Arthur", "cdupont@test.fr"));
        }

    }

    public void createUser(String name, String firstname, String email)
    {
        manager.persist(new User(name, firstname, email));
    }

    private List<User> getUser(String name)
    {
        String query = "SELECT u FROM User u WHERE u.name LIKE :name";
        return manager.createQuery(query, User.class).setParameter("name", name).getResultList();
    }

    public List<User> getUser()
    {
        String query = "SELECT u FROM User u";
        return manager.createQuery(query, User.class).getResultList();
    }

}
