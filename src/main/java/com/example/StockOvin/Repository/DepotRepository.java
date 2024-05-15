package com.example.StockOvin.Repository;

import com.example.StockOvin.Entities.DepotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepotRepository extends JpaRepository<DepotEntity, Integer> {
}
