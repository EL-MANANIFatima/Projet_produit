package com.example.projet_produit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public class CategorieDTO {
    private Long categoryId;
    private String categoryName;
    private List<String> featureNames;

    public CategorieDTO() {
        // Constructeur par défaut vide requis pour la désérialisation JSON
    }
    public CategorieDTO(Categorie category) {
        this.categoryId = category.getId();
        this.categoryName = category.getName();
        this.featureNames = category.getFeatures().stream()
                .map(Caracteristique::getName)
                .collect(Collectors.toList());
    }




    public String getCategoryName() {
        return categoryName;
    }

    // Getter pour l'attribut "categoryId"
    public Long getCategoryId() {
        return categoryId;
    }

    // Getter pour l'attribut "featureNames"
    public List<String> getFeatureNames() {
        return featureNames;
    }

    public void setFeatureNames(List<String> featureNames) {
        this.featureNames = featureNames;
    }

}
