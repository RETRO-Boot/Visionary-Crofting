package com.retro.visionarycrofting.entities;

import com.retro.visionarycrofting.enumeration.StatusAppel;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "appelOffre")
public class AppelOffre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private StatusAppel status;
    private int quantity;
    private String refProduct;
    @ManyToOne(fetch = FetchType.LAZY)
    private Stock stock;
    @ManyToOne(fetch = FetchType.LAZY)
    private Fournissour fournissour;

    //


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

    public Fournissour getFournissour() {
        return fournissour;
    }

    public void setFournissour(Fournissour fournissour) {
        this.fournissour = fournissour;
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
