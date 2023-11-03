package com.example.projet_produit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore

    private List<Caracteristique> features;

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

    public List<Caracteristique> getFeatures() {
        return features;
    }
    // Setter pour l'attribut "features"
    public void setFeatures(List<Caracteristique> features) {
        this.features = features;
    }



}
