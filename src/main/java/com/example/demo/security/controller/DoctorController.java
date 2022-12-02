package com.example.demo.security.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.appli.entity.Doctor;



@RestController
@RequestMapping("docteur")
public class DoctorController {

    private final List<Doctor> repositoryDoctor;

    public DoctorController() {
        repositoryDoctor = new ArrayList<>();
        repositoryDoctor.add(new Doctor(1,"OSTERTAG","Thomas"));
        repositoryDoctor.add(new Doctor(2, "SCHLINGER","Mme"));
    }

    @GetMapping()
    public List<Doctor> doctors() {
        return repositoryDoctor;
    }

    @PostMapping()
    public Doctor newBiere(@RequestBody Doctor newDoc) {
        repositoryDoctor.add(newDoc);
         return newDoc;
    }
}
