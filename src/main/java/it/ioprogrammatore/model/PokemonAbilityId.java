package it.ioprogrammatore.model;

import java.io.Serializable;
import java.util.Objects;

public class PokemonAbilityId implements Serializable {
    private int pokemon;
    private int ability;

    public PokemonAbilityId() {}

    public PokemonAbilityId(int pokemon, int ability) {
        this.pokemon = pokemon;
        this.ability = ability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonAbilityId that = (PokemonAbilityId) o;
        return pokemon == that.pokemon && ability == that.ability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemon, ability);
    }
}
