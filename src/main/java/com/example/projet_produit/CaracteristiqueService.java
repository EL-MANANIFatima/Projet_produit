package com.example.projet_produit;

import java.util.List;

public interface CaracteristiqueService {
    List<Caracteristique> getCaracteristiquesByCategoryId(Long categoryId); // Add this method
    List<Caracteristique> getCaracteristiqueByCategory(Categorie categorie);

}
