package com.example.projet_produit;

import java.util.List;
import java.util.List;

public class ProduitDetailsDto {

    private Long typeId;
    private String productName;
    private List<CaracteristiqueValeurDto> caracteristiqueValeurs;

    // Getters and setters
    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<CaracteristiqueValeurDto> getCaracteristiqueValeurs() {
        return caracteristiqueValeurs;
    }

    public void setCaracteristiqueValeurs(List<CaracteristiqueValeurDto> caracteristiqueValeurs) {
        this.caracteristiqueValeurs = caracteristiqueValeurs;
    }
}
