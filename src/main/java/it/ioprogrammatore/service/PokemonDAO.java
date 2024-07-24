package it.ioprogrammatore.service;

import it.ioprogrammatore.model.PokemonDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class PokemonDAO extends JPAPokemonDAO{

    public void createPokemon(PokemonDTO pokemon) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pokemon);
        em.getTransaction().commit();
        em.close();
    }

    public PokemonDTO getPokemonById(int id) {
        EntityManager em = emf.createEntityManager();
        PokemonDTO pokemon = em.find(PokemonDTO.class, id);
        em.close();
        return pokemon;
    }

    public void updatePokemon(PokemonDTO pokemon) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(pokemon);
        em.getTransaction().commit();
        em.close();
    }

    public void deletePokemonById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        PokemonDTO pokemon = this.getPokemonById(id);
        if (pokemon != null) {
            em.remove(pokemon);
        }
        em.getTransaction().commit();
        em.close();

    }

    public List<PokemonDTO> getAllPokemonByTrainerName(String name) {
        EntityManager em = emf.createEntityManager();
        String query = "select p from PokemonDTO p JOIN p.trainer t where t.name = :name";
        TypedQuery<PokemonDTO> queryTyped = em.createQuery(query, PokemonDTO.class);
        queryTyped.setParameter("name", name);
        return queryTyped.getResultList();
    }


}
