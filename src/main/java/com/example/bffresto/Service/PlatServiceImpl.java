package com.example.bffresto.Service;

import com.example.bffresto.Entites.Plat;
import com.example.bffresto.Repository.PlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatServiceImpl implements PlatService {

    private final PlatRepository platRepository;

    @Autowired
    public PlatServiceImpl(PlatRepository platRepository) {
        this.platRepository = platRepository;
    }
    @Override
    public Plat ajouterPlat(Plat plat) {
        return platRepository.save(plat);
    }
    @Override
    public List<Plat> obtenirPlatsDisponibles() {


        return  platRepository.findAll();
    }
    @Override
    public Plat obtenirInfoPlat(Long platId) {

        return platRepository.findById(platId).orElse(null);
    }
    @Override
    public Plat mettreAJourInfoPlat(Long platId, Plat plat) {

        Plat platExist = platRepository.findById(platId).orElse(null);
        if (platExist != null) {
            platExist.setName(plat.getName());
            platExist.setPrice(plat.getPrice());
            platExist.setDescription(plat.getDescription());
            platExist.setType(plat.getType());
            return platRepository.save(platExist);
        } else {
            return null; // Plat non trouvé
        }
    }
}
