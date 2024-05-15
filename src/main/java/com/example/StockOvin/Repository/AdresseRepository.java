package com.example.StockOvin.Repository;

import com.example.StockOvin.Entities.AdresseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends JpaRepository<AdresseEntity, Integer> {
}
