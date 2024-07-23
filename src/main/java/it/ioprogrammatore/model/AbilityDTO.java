package it.ioprogrammatore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;;

@Getter
@Setter
@Entity
@Table(name = "Abilities")
public class AbilityDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ability_id")
    private int abilityId;

    private String description;

}
