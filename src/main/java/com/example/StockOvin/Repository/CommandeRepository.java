package com.example.StockOvin.Repository;

import com.example.StockOvin.Entities.CommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<CommandeEntity, String> {
}
