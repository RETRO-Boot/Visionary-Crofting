package com.retro.visionarycrofting.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity(name = "Command")
public class Command implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String ref ;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date date ;
    private Double prixTotal ;

  @OneToMany(mappedBy = "command", orphanRemoval = true)
  private List<CommandItem> commandItems = new ArrayList<>();


  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "client_id")
  private Client client;

  @JsonIgnore
  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }


  public List<CommandItem> getCommandItems() {
    return commandItems;
  }

  public void setCommandItems(List<CommandItem> commandItems) {
    this.commandItems = commandItems;
  }

  public Command(){};

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", date=" + date +
                ", prixTotal=" + prixTotal +
                ", commandItems=" + commandItems +
                '}';
    }

//    @JsonIgnore
//    public List<CommandItem> getCommandItems() {
//        return commandItems;
//    }
//
//    public void setCommandItems(List<CommandItem> commandItems) {
//        this.commandItems = commandItems;
//    }
}
