package com.retro.visionarycrofting.entities;

import com.retro.visionarycrofting.enumeration.StatusAppel;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "appelOffre")
public class AppelOffre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ref;
    private String refProduct;
    private int quantity;
    private StatusAppel status;
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;
    @ManyToOne(fetch = FetchType.LAZY)
    private Fournisseur fournisseur;

    //


    public AppelOffre(String refProduct, int quantity, Stock stock) {
        this.refProduct = refProduct;
        this.quantity = quantity;
        this.stock = stock;
    }

    public AppelOffre() {
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

    public StatusAppel getStatus() {
        return status;
    }

    public void setStatus(StatusAppel status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRefProduct() {
        return refProduct;
    }

    public void setProduct(String product) {
        this.refProduct = product;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    @Override
    public String toString() {
        return "AppelOffre{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", status=" + status +
                ", quantity=" + quantity +
                ", product=" + refProduct +
                ", stock=" + stock +
                '}';
    }
}
