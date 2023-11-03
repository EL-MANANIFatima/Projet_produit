package com.example.projet_produit;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CaracteristiqueDTO {
    private Long id;
    private String name;


    public CaracteristiqueDTO(Caracteristique caracteristique) {
        this.id = caracteristique.getId();
        this.name = caracteristique.getName();
        // Vous pouvez ajouter d'autres propriétés si nécessaire
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setId(Long Id) {
        this.id = Id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
