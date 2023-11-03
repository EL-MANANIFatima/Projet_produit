package com.example.projet_produit;

import jakarta.persistence.*;


@Entity
public class Caracteristique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categorie category;

    // Getters, setters et constructeurs
    public Long getId() {
        return id;
    }

    // Setter pour l'attribut "id"
    public void setId(Long id) {
        this.id = id;
    }

    // Getter pour l'attribut "name"
    public String getName() {
        return name;
    }

    // Setter pour l'attribut "name"
    public void setName(String name) {
        this.name = name;
    }

    // Getter pour l'attribut "category"
    public Categorie getCategory() {
        return category;
    }

    public void setCategorie(Categorie category) {
        this.category = category;
    }


    public void setFeatureName(String featureName) {
    }


}
