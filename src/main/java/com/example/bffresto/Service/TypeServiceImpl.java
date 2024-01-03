package com.example.bffresto.Service;

import com.example.bffresto.Entites.Type;
import com.example.bffresto.Repository.TypeRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private TypeRepository typeRespository;

    public TypeServiceImpl(TypeRepository typeRespository) {
        this.typeRespository = typeRespository;
    }

    @Override
    public List<Type> optenirTypeDisponible() {
        return typeRespository.findAll();
    }

    @Override
    public Type ajoutTypePlat(Type type) {
        return typeRespository.save(type);

    }

    @Override
    public Type obtenirType(Long typeId) {
        return typeRespository.findById(typeId).orElse(null);
    }

    @Override
    public Type mettreAJourInfoType(Long typetId, Type type) {
        Type newtype = obtenirType(typetId);
        if (newtype != null){
                newtype.setNom(type.getNom());
                return ajoutTypePlat(newtype);
        }else {
            return null;
        }
    }
}
