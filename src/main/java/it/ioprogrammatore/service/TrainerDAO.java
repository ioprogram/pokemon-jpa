package it.ioprogrammatore.service;

import it.ioprogrammatore.model.TrainerDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TrainerDAO extends JPAPokemonDAO{

    public void createTrainer(TrainerDTO trainer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(trainer);
        em.getTransaction().commit();
        em.close();
    }

    public TrainerDTO getTrainerById(int id) {
        EntityManager em = emf.createEntityManager();
        TrainerDTO trainer = em.find(TrainerDTO.class, id);
        em.close();
        return trainer;
    }

    public void updateTrainer(TrainerDTO trainer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(trainer);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteTrainer(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TrainerDTO trainer = this.getTrainerById(id);
        if (trainer != null) {
            em.remove(trainer);
        }
        em.getTransaction().commit();
        em.close();
    }

}
