package net.mahtabalam;

import javax.persistence.EntityManager;

public class AuthorService {

    private EntityManager em;

    public AuthorService(EntityManager em) {
        this.em = em;
    }

    public Author createAuthor(Author author) {
        em.persist(author);
        return author;
    }

    public void removeAuthor(Author author) {
        em.remove(em.merge(author));
    }

    public Author findAuthor(Long id) {
        return em.find(Author.class, id);
    }
}