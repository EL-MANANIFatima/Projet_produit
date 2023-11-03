package com.example.projet_produit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryFeatureRepository extends JpaRepository<Caracteristique, Long> {
}
