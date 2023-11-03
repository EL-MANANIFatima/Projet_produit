package com.example.projet_produit;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final CategoryRepository typeRepository;
    private final CaracteristiqueRepository caracteristiqueRepository;

    @Autowired
    public ProduitService(ProduitRepository produitRepository, CategoryRepository typeRepository, CaracteristiqueRepository caracteristiqueRepository) {
        this.produitRepository = produitRepository;
        this.typeRepository = typeRepository;
        this.caracteristiqueRepository = caracteristiqueRepository;
    }

    public Produit saveProduitWithDetails(Long typeId, String productName, List<CaracteristiqueValeurDto> caracteristiqueValeurs) {
        Categorie type = typeRepository.findById(typeId).orElseThrow(() -> new EntityNotFoundException("Type not found with ID: " + typeId));
        Produit produit = new Produit();
        produit.setProductName(productName);
        produit.setType(type);

        for (CaracteristiqueValeurDto caracteristiqueValeurDto : caracteristiqueValeurs) {
            Long caracteristiqueId = caracteristiqueValeurDto.getCaracteristiqueId();
            String valeur = caracteristiqueValeurDto.getValeur();

            Caracteristique caracteristique = caracteristiqueRepository.findById(caracteristiqueId).orElseThrow(() -> new EntityNotFoundException("Caracteristique not found with ID: " + caracteristiqueId));
            CaracteristiqueValeur caracteristiqueValeur = new CaracteristiqueValeur();
            caracteristiqueValeur.setCaracteristique(caracteristique);
            caracteristiqueValeur.setValeur(valeur);
            caracteristiqueValeur.setProduit(produit);
            produit.addCaracteristiqueValeur(caracteristiqueValeur);
        }

        return produitRepository.save(produit);
    }
}

