package net.mahtabalam;

import javax.persistence.EntityManager;

public class CDService {

    private EntityManager em;

    public CDService(EntityManager em) {
        this.em = em;
    }

    public CD createCD(CD cd) {
        em.persist(cd);
        return cd;
    }

    public void removeCD(CD cd) {
        em.remove(em.merge(cd));
    }

    public CD findCD(Long id) {
        return em.find(CD.class, id);
    }
}