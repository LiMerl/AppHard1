package com.example.demo.appli.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient{
   @Id
   @Column(name= "id_patient")
    private Integer id;
    private String nom;
    private String prenom;
    private String birthDate;

    public void setId(Integer id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
    public Integer getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getBirthDate() {
        return birthDate;
    }
    
}
