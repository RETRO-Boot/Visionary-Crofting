package com.retro.visionarycrofting.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String userName ;
    private String email ;
    private String password ;
    private String Tel ;


    public Client() {};

    public Client(Long id, String userName, String email, String password, String tel) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.Tel = tel;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", Tel='" + Tel + '\'' +
                '}';
    }
}
