package it.ioprogrammatore;

import it.ioprogrammatore.model.PokemonDTO;
import it.ioprogrammatore.model.TrainerDTO;
import it.ioprogrammatore.model.TypeDTO;
import it.ioprogrammatore.service.AbilityDAO;
import it.ioprogrammatore.service.PokemonDAO;
import it.ioprogrammatore.service.TrainerDAO;
import it.ioprogrammatore.service.TypeDAO;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // DAO
        PokemonDAO pokemonDAO = new PokemonDAO();
        TrainerDAO trainerDAO = new TrainerDAO();
        TypeDAO typeDAO = new TypeDAO();

//        // Step 1 - create a type
        TypeDTO type = new TypeDTO();
        type.setDescription("Fire");
        typeDAO.createType(type);

//        // Step 2 - create Trainer
        TrainerDTO trainer = new TrainerDTO();
        trainer.setName("Michele");
        trainerDAO.createTrainer(trainer);

        // Step 3 - create Pokemon
        PokemonDTO pokemon = new PokemonDTO();
        pokemon.setName("Charmander");
        pokemon.setType(type);
        pokemon.setTrainer(trainer);
        pokemonDAO.createPokemon(pokemon);

        // Step 4 - create Pokemon with existing type and trainer
        TypeDTO typeById = typeDAO.getTypeById(1);
        TrainerDTO trainerById = trainerDAO.getTrainerById(1);

        PokemonDTO pokemon2 = new PokemonDTO();
        pokemon2.setName("Magmar");
        pokemon2.setType(typeById);
        pokemon2.setTrainer(trainerById);
        pokemonDAO.createPokemon(pokemon2);

        // Querying example
        AbilityDAO abilityDAO = new AbilityDAO();
        List<Object[]> objects = abilityDAO.countAbilitiesByDescriptionHavingGreatThanOne();

        objects.forEach( res -> {
            System.out.println(res[0] + ": " + res[1]);
        });

        List<PokemonDTO> sabrinaPokemon = pokemonDAO.getAllPokemonByTrainerName("Sabrina");
        sabrinaPokemon.forEach(System.out::println);

    }

}
