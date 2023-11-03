package com.example.projet_produit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaracteristiqueRepository extends JpaRepository<Caracteristique, Long> {

    List<Caracteristique> findByCategoryId(Long categoryId);

    List<Caracteristique> findByCategory(Categorie categorie);
}
