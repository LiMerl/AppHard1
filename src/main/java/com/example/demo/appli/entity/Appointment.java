package com.example.demo.appli.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
    @Id
    private Integer id_appointment;
    private LocalDateTime date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_vaccination_center", nullable = false, foreignKey = @ForeignKey(name = "adresse_fk"))
    private VaccinationCenter center;

    public Appointment() {
    }

    public Appointment(Integer id_appointment, LocalDateTime date, VaccinationCenter center) {
        this.id_appointment = id_appointment;
        this.date = date;
        this.center = center;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Integer getId_appointment() {
        return id_appointment;
    }

    public void setId_appointment(Integer id_appointment) {
        this.id_appointment = id_appointment;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
