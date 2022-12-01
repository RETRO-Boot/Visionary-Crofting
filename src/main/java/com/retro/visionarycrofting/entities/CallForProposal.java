package com.retro.visionarycrofting.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.retro.visionarycrofting.enumeration.CallForProposalStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CallForProposal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ref;
    private String refProduct;
    private Integer quantity;
    private CallForProposalStatus status;
    @ManyToOne
    private Stock stock;
    @ManyToOne
    private Fournisseur fournisseur;
    public CallForProposal(String refProduct, int quantity, Stock stock) {
        this.refProduct = refProduct;
        this.quantity = quantity;
        this.stock = stock;
    }

    public CallForProposal() {
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

    public CallForProposalStatus getStatus() {
        return status;
    }

    public void setStatus(CallForProposalStatus status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRefProduct() {
        return refProduct;
    }

    public void setProduct(String refProduct) {
        this.refProduct = refProduct;
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
        return "CallForProposal{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", refProduct='" + refProduct + '\'' +
                ", quantity=" + quantity +
                ", status=" + status +
                ", stock=" + stock +
                ", fournisseur=" + fournisseur +
                '}';
    }
}
