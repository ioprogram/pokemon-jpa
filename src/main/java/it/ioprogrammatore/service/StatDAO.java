package it.ioprogrammatore.service;

import it.ioprogrammatore.model.StatDTO;
import jakarta.persistence.EntityManager;

public class StatDAO extends JPAPokemonDAO{

    public void createStat(StatDTO stat) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(stat);
        em.getTransaction().commit();
        em.close();
    }

    public StatDTO getStatById(int id) {
        EntityManager em = emf.createEntityManager();
        StatDTO stat = em.find(StatDTO.class, id);
        em.close();
        return stat;
    }

    public void updateStat(StatDTO stat) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(stat);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteStat(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        StatDTO stat = em.find(StatDTO.class, id);
        if (stat != null) {
            em.remove(stat);
        }
        em.getTransaction().commit();
        em.close();
    }
}
