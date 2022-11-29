package com.retro.visionarycrofting.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private long prix;
    private String description;
    private int quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Stock stock;
    @Enumerated(EnumType.STRING)
    private Category category;

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

    public long getPrix() {
        return prix;
    }

    public void setPrix(long prix) {
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
                '}';
    }
}
