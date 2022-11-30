package com.retro.visionarycrofting.services.implementation;

import com.retro.visionarycrofting.entities.Product;
import com.retro.visionarycrofting.entities.Stock;
import com.retro.visionarycrofting.enumeration.Category;
import com.retro.visionarycrofting.repositories.ProductDao;
import com.retro.visionarycrofting.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
    @Autowired
    StockServiceImpl stockService;

    @Override
    public List<Product> findAllByQuantityGreaterThan(int quantity) {
        return productDao.findAllByQuantityGreaterThanEqual(quantity);
    }

    @Override
    public List<Product> findAllByPrixGreaterThan(long prix) {
        return productDao.findAllByPrixGreaterThanEqual(prix);
    }

    @Override
    public List<Product> findAllByStockName(String name) {
        return productDao.findAllByStockName(name);
    }

    @Override
    public Product findByRef(String ref) {
        return productDao.findByRef(ref);
    }

    @Override
    public List<Product> findAllByName(String name) {
        return productDao.findAllByName(name);
    }

    @Override
    public List<Product> findAllByCategory(String cat) {
        try {
            Category catEnum = Category.valueOf(String.valueOf(cat));
            return productDao.findAllByCategory(catEnum);
        } catch (IllegalArgumentException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Product> findAllByCategoryAndPrixGreaterThan(String cat, long prix) {
        try {
            Category catEnum = Category.valueOf(String.valueOf(cat));
            return productDao.findAllByCategoryAndPrixGreaterThanEqual(catEnum, prix);
        } catch (IllegalArgumentException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Product> findAllByCategoryAndQuantityGreaterThan(String cat, int quantity) {
        try {
            Category catEnum = Category.valueOf(String.valueOf(cat));
            return productDao.findAllByCategoryAndQuantityGreaterThanEqual(catEnum, quantity);
        } catch (IllegalArgumentException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return productDao.deleteByRef(ref);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    @Deprecated
    public Product getOne(Long aLong) {
        return productDao.getOne(aLong);
    }

    public Product save(Product product, String name) {
        Stock stock = this.stockService.findByName(name);
        if (stock == null) {
            System.out.println("Stock not found");
            return null;
        }
        product.setStock(stock);
        if(this.findByRef(product.getRef()) != null) {
            System.out.println("Ref already exist");
            return null;
        }
        return productDao.save(product);
    }

    @Override
    public Product update(Product product) {
        if(this.findByRef(product.getRef()) == null) return null;
        if(this.getOne(product.getId()) == null) return null;
        return productDao.save(product);
    }
}
