package com.example.demo.appli.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
    private Integer id_doctor;
    private String name;
    private String surname;

    public Doctor(Integer id_doctor,String name,String surname){
        this.id_doctor = id_doctor;
        this.name =  name;
        this.surname = surname;
    }
    public Integer getId_doctor() {
        return id_doctor;
    }
    public void setId_doctor(Integer id_doctor) {
        this.id_doctor = id_doctor;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {

    }
    

}
