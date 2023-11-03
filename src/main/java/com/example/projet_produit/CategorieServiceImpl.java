package com.example.projet_produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategorieServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryFeatureRepository categoryFeatureRepository;



    @Override
    public Categorie createCategory(Categorie category) {
        // Vous pouvez ajouter une logique de validation ici si nécessaire
        return categoryRepository.save(category);
    }



    @Override
    public List<Categorie> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Categorie getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public Categorie updateCategory(Long categoryId, Categorie updatedCategory) {
        Categorie existingCategory = categoryRepository.findById(categoryId).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(updatedCategory.getName());
            // Mettez à jour les caractéristiques si nécessaire
            existingCategory.setFeatures(updatedCategory.getFeatures());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

        }


