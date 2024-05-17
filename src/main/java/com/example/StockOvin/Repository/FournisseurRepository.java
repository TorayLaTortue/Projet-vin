package com.example.StockOvin.Repository;

import com.example.StockOvin.Entities.FournisseurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<FournisseurEntity, Integer> {
}
