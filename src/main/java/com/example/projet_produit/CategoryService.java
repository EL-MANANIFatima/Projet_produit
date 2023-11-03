package com.example.projet_produit;

import java.util.List;
import java.util.stream.Collectors;

public interface CategoryService {



    Categorie createCategory(Categorie category);

    List<Categorie> getAllCategories();

    Categorie getCategoryById(Long categoryId);

    Categorie updateCategory(Long categoryId, Categorie updatedCategory);

    void deleteCategory(Long categoryId);

}
