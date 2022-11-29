package com.retro.visionarycrofting.repositories;

import com.retro.visionarycrofting.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockDao extends JpaRepository<Stock, Long> {
    List<Stock> findAllByAddress(String address);
    Stock findByName(String address);
    Stock findByEmail(String address);
    int deleteByName(String address);
    int deleteByEmail(String address);

}
