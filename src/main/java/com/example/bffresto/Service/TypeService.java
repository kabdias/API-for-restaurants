package com.example.bffresto.Service;


import com.example.bffresto.Entites.Type;

import java.util.List;

public interface TypeService {


    List<Type> optenirTypeDisponible();

    Type ajoutTypePlat(Type type);

    Type obtenirType(Long typeId);

    Type mettreAJourInfoType(Long typetId, Type type);
}
