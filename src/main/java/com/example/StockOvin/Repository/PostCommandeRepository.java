package com.example.StockOvin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.StockOvin.Entities.PostCommandeEntity;

@Repository
public interface PostCommandeRepository extends JpaRepository<PostCommandeEntity, Long> {

}
