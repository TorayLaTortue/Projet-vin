package com.example.StockOvin.Repository;

import com.example.StockOvin.Entities.DepositEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<DepositEntity, Integer> {
}
