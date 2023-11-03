package com.example.projet_produit;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;



@Entity
public class Produit {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Categorie type;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private List<CaracteristiqueValeur> caracteristiquesValeurs;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Categorie getType() {
        return type;
    }

    public void setType(Categorie type) {
        this.type = type;
    }

    public List<CaracteristiqueValeur> getCaracteristiquesValeurs() {
        return caracteristiquesValeurs;
    }

    public void setCaracteristiquesValeurs(List<CaracteristiqueValeur> caracteristiquesValeurs) {
        this.caracteristiquesValeurs = caracteristiquesValeurs;
    }

    public void addCaracteristiqueValeur(CaracteristiqueValeur valeur) {
        this.caracteristiquesValeurs.add(valeur);
    }

    public Produit() {
        this.caracteristiquesValeurs = new ArrayList<>();
    }


}

