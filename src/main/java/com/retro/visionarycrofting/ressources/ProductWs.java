package com.retro.visionarycrofting.ressources;

import com.retro.visionarycrofting.entities.Product;
import com.retro.visionarycrofting.services.implementation.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${api.endpoint}/product")
public class ProductWs {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/quantity/{quantity}")
    public List<Product> findAllByQuantityGreaterThan(@PathVariable int quantity) {
        return productService.findAllByQuantityGreaterThan(quantity);
    }

    @GetMapping("/prix/{prix}")
    public List<Product> findAllByPrixGreaterThan(@PathVariable long prix) {
        return productService.findAllByPrixGreaterThan(prix);
    }

    @GetMapping("/cat/{cat}/prix/{prix}")
    public List<Product> findAllByCategoryAndPrixGreaterThan(@PathVariable String cat,@PathVariable long prix) {
        return productService.findAllByCategoryAndPrixGreaterThan(cat, prix);
    }

    @GetMapping("/cat/{cat}/quantity/{quantity}")
    public List<Product> findAllByCategoryAndQuantityGreaterThan(@PathVariable String cat, @PathVariable int quantity) {
        return productService.findAllByCategoryAndQuantityGreaterThan(cat, quantity);
    }

    @GetMapping("/stock/{name}")
    public List<Product> findAllByStockName(@PathVariable String name) {
        return productService.findAllByStockName(name);
    }

    @GetMapping("/ref/{ref}")
    public Product findByRef(@PathVariable String ref) {
        return productService.findByRef(ref);
    }

    @GetMapping("/name/{name}")
    public List<Product> findAllByName(@PathVariable String name) {
        return productService.findAllByName(name);
    }

    @GetMapping("/cat/{cat}")
    public List<Product> findAllByCategory(@PathVariable String  cat) {
        return productService.findAllByCategory(cat);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return productService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/id/{id}")
    public Product getOne(@PathVariable Long aLong) {
        return productService.getOne(aLong);
    }

    @PostMapping("/stock/{name}")
    public Product save(@RequestBody Product product, @PathVariable String name) {
        return productService.save(product, name);
    }

    @PutMapping("/")
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }
}
