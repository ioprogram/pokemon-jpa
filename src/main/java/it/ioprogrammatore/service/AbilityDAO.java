package it.ioprogrammatore.service;

import it.ioprogrammatore.model.AbilityDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AbilityDAO extends JPAPokemonDAO {

    public void createAbility(AbilityDTO ability) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(ability);
        em.getTransaction().commit();
        em.close();
    }

    public AbilityDTO getAbilityById(int id) {
        EntityManager em = emf.createEntityManager();
        AbilityDTO ability = em.find(AbilityDTO.class, id);
        em.close();
        return ability;
    }

    public void updateAbility(AbilityDTO ability) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(ability);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteAbility(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        AbilityDTO ability = em.find(AbilityDTO.class, id);
        if (ability != null) {
            em.remove(ability);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Object[]> countAbilitiesByDescriptionHavingGreatThanOne() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT a.description, COUNT(pa) " +
                        "FROM PokemonAbility pa " +
                        "JOIN pa.ability a " +
                        "GROUP BY a.description " +
                        "HAVING COUNT(pa) > 1", Object[].class);
        List<Object[]> results = query.getResultList();
        em.close();
        return results;
    }
}
