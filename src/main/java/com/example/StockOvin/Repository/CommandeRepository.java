package com.example.StockOvin.Repository;

import com.example.StockOvin.Entities.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<CommandeEntity, Long> {
}
