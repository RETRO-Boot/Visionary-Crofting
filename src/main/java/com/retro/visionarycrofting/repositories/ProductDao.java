package com.retro.visionarycrofting.repositories;

import com.retro.visionarycrofting.entities.Product;
import com.retro.visionarycrofting.enumeration.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    List<Product> findAllByQuantityGreaterThanEqual(int quantity);
    List<Product> findAllByPrixGreaterThanEqual(long prix);
    List<Product> findAllByStockName(String name);
    Product findByRef(String ref);
    List<Product> findAllByName(String name);
    List<Product> findAllByCategory(Category cat);
    List<Product> findAllByCategoryAndPrixGreaterThanEqual(Category cat, long prix);
    List<Product> findAllByCategoryAndQuantityGreaterThanEqual(Category cat, int quantity);
    int deleteByRef(String ref);
}
