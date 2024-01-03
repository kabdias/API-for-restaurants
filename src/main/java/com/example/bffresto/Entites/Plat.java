package com.example.bffresto.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Utilisateur> utilisateur;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Reservation> reservations;

}
