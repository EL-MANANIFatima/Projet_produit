package com.example.projet_produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategrieController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CaracteristiqueService caracteristiqueService;



    @PostMapping("/create")
    public ResponseEntity<Categorie> createCategory(@RequestBody CategorieDTO categoryDTO) {
        Categorie newCategory = new Categorie();
        newCategory.setName(categoryDTO.getCategoryName());

        List<Caracteristique> features = new ArrayList<>();
        for (String featureName : categoryDTO.getFeatureNames()) {
            Caracteristique feature = new Caracteristique();
            feature.setName(featureName);
            feature.setCategorie(newCategory);
            features.add(feature);
        }

        newCategory.setFeatures(features);

        Categorie createdCategory = categoryService.createCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @GetMapping("/{categoryId}/category-caracteristiques")
    public ResponseEntity<List<CaracteristiqueDTO>> getCategoryCaracteristiques(@PathVariable Long categoryId) {
        Categorie category = categoryService.getCategoryById(categoryId);
        if (category != null) {
            List<Caracteristique> caracteristiques = caracteristiqueService.getCaracteristiqueByCategory(category);
            List<CaracteristiqueDTO> dtos = new ArrayList<>();
            for (Caracteristique caracteristique : caracteristiques) {
                CaracteristiqueDTO dto = new CaracteristiqueDTO();
                dto.setId(caracteristique.getId());
                dto.setName(caracteristique.getName());
                dtos.add(dto);
            }

            return ResponseEntity.ok(dtos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/all")
    public ResponseEntity<List<CategorieDTO>> getAllCategories() {
        List<Categorie> categories = categoryService.getAllCategories();

        if (categories != null && !categories.isEmpty()) {
            List<CategorieDTO> categoryDTOs = new ArrayList<>();
            for (Categorie category : categories) {
                CategorieDTO categoryDTO = new CategorieDTO(category);
                categoryDTOs.add(categoryDTO);
            }
            return ResponseEntity.ok(categoryDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
