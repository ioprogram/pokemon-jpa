package it.ioprogrammatore;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokemon-jpa");

    public static void main(String[] args) {

    }

//    public static void main(String[] args) {
//        EntityManager em = emf.createEntityManager();
//
//        // Create a new Type
//        em.getTransaction().begin();
//        Type fireType = new Type();
//        fireType.setDescription("Fire");
//        em.persist(fireType);
//        em.getTransaction().commit();
//
//        // Create a new Trainer
//        em.getTransaction().begin();
//        Trainer ash = new Trainer();
//        ash.setName("Ash Ketchum");
//        em.persist(ash);
//        em.getTransaction().commit();
//
//        // Create a new Pokemon
//        em.getTransaction().begin();
//        Pokemon charmander = new Pokemon();
//        charmander.setName("Charmander");
//        charmander.setType(fireType);  // Set the type
//        charmander.setTrainer(ash);    // Set the trainer
//        em.persist(charmander);
//        em.getTransaction().commit();
//
//        // Read all Pokémon
//        TypedQuery<Pokemon> query = em.createQuery("SELECT p FROM Pokemon p", Pokemon.class);
//        List<Pokemon> pokemons = query.getResultList();
//        for (Pokemon pokemon : pokemons) {
//            System.out.println("Pokemon: " + pokemon.getName() + ", Type: " + pokemon.getType().getDescription() + ", Trainer: " + pokemon.getTrainer().getName());
//        }
//
//        // Update a Pokemon
//        em.getTransaction().begin();
//        charmander.setName("Charmeleon");
//        em.merge(charmander);
//        em.getTransaction().commit();
//
//        // Delete a Pokemon
//        em.getTransaction().begin();
//        em.remove(charmander);
//        em.getTransaction().commit();
//
//        em.close();
//        emf.close();
//    }
}
