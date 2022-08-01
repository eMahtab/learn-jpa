package net.mahtabalam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManagerFactory");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        AuthorService service = new AuthorService(em);
        Author author = new Author("Douglas",
                "Adams",
                "Adams is best known as the author of H2G2",
                LocalDate.of(2017, 1, 13),
                49, Language.ENGLISH);

        // Creates and persists an author
        tx.begin();
        author = service.createAuthor(author);
        tx.commit();
        Long id = author.getId();

        System.out.println("Author Persisted : " + author);

        // Finds the author
        author = service.findAuthor(id);

        System.out.println("Author Found     : " + author);

        // Removes the author
        tx.begin();
        service.removeAuthor(author);
        tx.commit();

        System.out.println("Author Removed");

        // Finds the author
        author = service.findAuthor(id);

        System.out.println("Author Not Found : " + author);

        em.close();
        emf.close();
    }
}


