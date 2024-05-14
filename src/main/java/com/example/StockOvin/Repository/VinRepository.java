
package com.example.StockOvin.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StockOvin.Entities.VinEntity;

@Repository    //pour declarer que c'est bien une interface qui gere l'acces aux données 
public interface VinRepository  extends JpaRepository<VinEntity, Long>{
    
List<VinEntity> findAll();

} 