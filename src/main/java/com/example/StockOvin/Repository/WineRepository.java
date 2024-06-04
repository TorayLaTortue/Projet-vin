
package com.example.StockOvin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StockOvin.Entities.WineEntity;

@Repository
public interface WineRepository  extends JpaRepository<WineEntity, Integer>{

} 