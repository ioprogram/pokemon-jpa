package it.ioprogrammatore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "Pokemon")
@ToString
public class PokemonDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pokemon_id")
    private int pokemonId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private TypeDTO type;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private TrainerDTO trainer;

}
