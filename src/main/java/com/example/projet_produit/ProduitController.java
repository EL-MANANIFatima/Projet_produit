package com.example.projet_produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produits")
@CrossOrigin(origins = "http://localhost:3000")

public class ProduitController {

    private final ProduitService produitService;

    @Autowired
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveProduitWithDetails(@RequestBody ProduitDetailsDto produitDetailsDto) {
        try {
            Produit savedProduit = produitService.saveProduitWithDetails(produitDetailsDto.getTypeId(), produitDetailsDto.getProductName(), produitDetailsDto.getCaracteristiqueValeurs());
            String successMessage = "Product saved successfully.";
            return new ResponseEntity<>(successMessage, HttpStatus.OK);
        } catch (Exception e) {
            String errorMessage = "An error occurred while saving the product: " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }
}

