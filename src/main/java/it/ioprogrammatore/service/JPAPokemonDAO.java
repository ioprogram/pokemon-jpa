package it.ioprogrammatore.service;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class JPAPokemonDAO {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokemon-jpa");
}
