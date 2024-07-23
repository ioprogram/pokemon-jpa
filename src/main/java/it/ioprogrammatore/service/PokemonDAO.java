package it.ioprogrammatore.service;

import it.ioprogrammatore.model.PokemonDTO;
import jakarta.persistence.EntityManager;


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


}
