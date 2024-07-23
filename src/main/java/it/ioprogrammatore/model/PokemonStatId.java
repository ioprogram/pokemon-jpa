package it.ioprogrammatore.model;

import java.io.Serializable;
import java.util.Objects;

public class PokemonStatId implements Serializable {
    private int pokemon;
    private int stat;

    public PokemonStatId() {
    }

    public PokemonStatId(int pokemon, int stat) {
        this.pokemon = pokemon;
        this.stat = stat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonStatId that = (PokemonStatId) o;
        return pokemon == that.pokemon && stat == that.stat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemon, stat);
    }
}
