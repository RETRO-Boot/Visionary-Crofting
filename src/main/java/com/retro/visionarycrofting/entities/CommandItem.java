package com.retro.visionarycrofting.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "CommandItem")
public class CommandItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id ;
    private  String ref ;
    private  int quantite ;
    private  double prix ;
    @ManyToOne
    @JsonIgnore
    private Command command;

    public CommandItem(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "CommandItem{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                ", command=" + command +
                '}';
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
