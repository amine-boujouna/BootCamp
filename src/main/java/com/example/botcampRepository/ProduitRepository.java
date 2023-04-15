package com.example.botcampRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.botcampEntites.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long>{

}
