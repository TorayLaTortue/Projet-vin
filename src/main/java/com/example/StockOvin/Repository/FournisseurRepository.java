package com.example.StockOvin.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.StockOvin.Entities.FournisseurEntity;

@Repository
public interface FournisseurRepository extends JpaRepository<FournisseurEntity, Long> {
    List<FournisseurEntity> findAll();
}