package net.mahtabalam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManagerFactory");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        CDService service = new CDService(em);

        // Creates and persists a CD
        tx.begin();
        CD cd = service.createCD(new CD("Selling England by the Pound", "5th studio album by the progressive rock band Genesis", 12.5F, 53.39F, "Progressive Rock"));
        tx.commit();

        System.out.println("CD Persisted : " + cd);

        // Finds the cd by primary key
        cd = service.findCD(cd.getId());

        System.out.println("CD Found     : " + cd);

        // Deletes the cd
        tx.begin();
        service.removeCD(cd.getId());
        tx.commit();

        System.out.println("CD Removed");

        // Finds the cd  by primary key
        cd = service.findCD(cd.getId());

        System.out.println("CD Not Found : " + cd);

        em.close();
        emf.close();
    }
}


