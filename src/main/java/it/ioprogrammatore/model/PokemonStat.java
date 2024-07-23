package it.ioprogrammatore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Pokemon_Stats")
@IdClass(PokemonStatId.class)
public class PokemonStat {
    @Id
    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private PokemonDTO pokemon;

    @Id
    @ManyToOne
    @JoinColumn(name = "stat_id")
    private StatDTO stat;

    private int value;

}
