package it.ioprogrammatore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "Pokemon_Abilities")
@IdClass(PokemonAbilityId.class)
public class PokemonAbility {
    @Id
    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private PokemonDTO pokemon;

    @Id
    @ManyToOne
    @JoinColumn(name = "ability_id")
    private AbilityDTO ability;

}
