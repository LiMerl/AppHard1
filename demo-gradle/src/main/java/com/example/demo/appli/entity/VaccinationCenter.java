package com.example.demo.appli.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class VaccinationCenter {
    @Id
    private Integer id;
    private String name;
    private String addresse;
    private String postalCode;
    private String city;
    private String phoneNumber;

   
    public VaccinationCenter(){

    }
    public VaccinationCenter(Integer id, String name, String addresse, String postalCode, String city,
            List<Appointment> appointment, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.addresse = addresse;
        this.postalCode = postalCode;
        this.city = city;
        this.appointment = appointment;
        this.phoneNumber = phoneNumber;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @OneToMany(mappedBy = "center", fetch = FetchType.EAGER)
    private List<Appointment> appointment;

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getaddresse() {
        return addresse;
    }

    public void setaddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getpostalCode() {
        return postalCode;
    }

    public void setpostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<Appointment> appointment) {
        this.appointment = appointment;
    }
}
