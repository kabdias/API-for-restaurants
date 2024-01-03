package com.example.bffresto.Service;

import com.example.bffresto.Entites.Plat;

import java.util.List;

public interface PlatService {

    Plat ajouterPlat(Plat plat);

    List<Plat> obtenirPlatsDisponibles();

    Plat obtenirInfoPlat(Long platId);

    Plat mettreAJourInfoPlat(Long platId, Plat plat);
}