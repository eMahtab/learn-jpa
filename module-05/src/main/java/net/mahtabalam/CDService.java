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

    public void removeCD(Long id) {
        CD cd = em.find(CD.class, id);
        if (cd != null)
            em.remove(cd);
    }

    public CD findCD(Long id) {
        return em.find(CD.class, id);
    }
}