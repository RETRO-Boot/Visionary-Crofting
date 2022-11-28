package com.retro.visionarycrofting.entities;

import com.retro.visionarycrofting.enumeration.Category;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String name;
    private String prix;
    private String description;
    private int quantity;
    @ManyToOne
    private Stock stock;
    private Category category;
    @ManyToOne
    private Stock stocks;


    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Stock getStocks() {
        return stocks;
    }

    public void setStocks(Stock stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", name='" + name + '\'' +
                ", prix='" + prix + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", stock=" + stock +
                ", category=" + category +
                ", stocks=" + stocks +
                '}';
    }
}
