package com.example.projet_produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController

public class CaracteristiqueController {
    private final  CaracteristiqueService caracteristiqueService;

    @Autowired
    public CaracteristiqueController(CaracteristiqueService caracteristiqueService) {
        this.caracteristiqueService = caracteristiqueService;
    }


    @GetMapping("/categories/{categoryId}/caracteristiques")
    public List<CaracteristiqueDTO> getCaracteristiquesByCategoryId(@PathVariable Long categoryId) {
        List<Caracteristique> caracteristiques = caracteristiqueService.getCaracteristiquesByCategoryId(categoryId);

        // Vous devrez convertir les entités Caracteristique en DTO si nécessaire
        List<CaracteristiqueDTO> caracteristiquesDTO = convertToDTO(caracteristiques);

        return caracteristiquesDTO;
    }

    // Ajoutez d'autres méthodes du contrôleur si nécessaire

    private List<CaracteristiqueDTO> convertToDTO(List<Caracteristique> caracteristiques) {
        // Ici, vous devrez implémenter la logique pour convertir les entités Caracteristique en DTO.
        // Créez une classe CaracteristiqueDTO si ce n'est pas déjà fait.

        // Exemple de conversion
        return caracteristiques.stream()
                .map(caracteristique -> new CaracteristiqueDTO(caracteristique))
                .collect(Collectors.toList());
    }

}
