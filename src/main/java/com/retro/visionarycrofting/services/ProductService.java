package com.retro.visionarycrofting.services;

import com.retro.visionarycrofting.entities.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAllByQuantityGreaterThan(int quantity);

    public List<Product> findAllByPrixGreaterThan(long prix);

    public List<Product> findAllByStockName(String name);

    public Product findByRef(String ref);

    public List<Product> findAllByName(String name);

    public List<Product> findAllByCategory(String cat);

    public List<Product> findAllByCategoryAndPrixGreaterThan(String cat, long prix);

    public List<Product> findAllByCategoryAndQuantityGreaterThan(String cat, int quantity);

    public int deleteByRef(String ref);

    public List<Product> findAll();

    public Product getOne(Long aLong);

    public Product save(Product product, String name);

    public Product update(Product product);
}
