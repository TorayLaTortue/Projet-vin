package com.example.StockOvin.Repository;

import com.example.StockOvin.Entities.UpdateCommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateCommandeRepository extends JpaRepository<UpdateCommandeEntity, Integer> {
}
