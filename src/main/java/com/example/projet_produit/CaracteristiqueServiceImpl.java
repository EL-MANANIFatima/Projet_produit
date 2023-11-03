package com.example.projet_produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CaracteristiqueServiceImpl implements CaracteristiqueService {
    private final CaracteristiqueRepository caracteristiqueRepository;

    @Autowired
    public CaracteristiqueServiceImpl(CaracteristiqueRepository caracteristiqueRepository) {
        this.caracteristiqueRepository = caracteristiqueRepository;
    }



    @Override
    public List<Caracteristique> getCaracteristiquesByCategoryId(Long categoryId) {
        // Utilisez le repository pour obtenir les caractéristiques liées à une catégorie par son ID
        List<Caracteristique> caracteristiques = caracteristiqueRepository.findByCategoryId(categoryId);
        return caracteristiques;
    }

    @Override
    public List<Caracteristique> getCaracteristiqueByCategory(Categorie categorie) {
        List<Caracteristique> caracteristiques = caracteristiqueRepository.findByCategory(categorie);
        return caracteristiques;
    }
}
