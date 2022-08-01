package net.mahtabalam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("entityManagerFactory");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

        Book book = new Book();
        book.setId(1l);
        book.setTitle("Some Book Name");
        book.setDescription("Some Book Description");
        book.setIsbn("276-27262");
        book.setUnitCost(245.5f);
        book.setNbOfPage(412);

        persistBook(book);

        Book book1 = findBook(1l);

        System.out.println("# " + book1);
    }

    private static void persistBook(Book book) {
        entityManager.persist(book);
    }

    private static Book findBook(long id) {
        return entityManager.find(Book.class, id);
    }
}
