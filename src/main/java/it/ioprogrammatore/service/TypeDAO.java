package it.ioprogrammatore.service;

import it.ioprogrammatore.model.TypeDTO;
import jakarta.persistence.EntityManager;

public class TypeDAO extends JPAPokemonDAO {

    public void createType(TypeDTO type) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(type);
        em.getTransaction().commit();
        em.close();
    }

    public TypeDTO getTypeById(int id) {
        EntityManager em = emf.createEntityManager();
        TypeDTO type = em.find(TypeDTO.class, id);
        em.close();
        return type;
    }

    public void updateType(TypeDTO type) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(type);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteType(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypeDTO type = this.getTypeById(id);
        if (type != null) {
            em.remove(type);
        }
        em.getTransaction().commit();
        em.close();
    }

}
