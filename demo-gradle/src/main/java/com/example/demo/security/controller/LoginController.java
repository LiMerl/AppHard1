package com.example.demo.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class LoginController {

    MeterRegistry meterRegistry;
    
    public LoginController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }
    @GetMapping(path = "api/login")
    public ResponseEntity<Void>  sendOK() {
        meterRegistry.counter("nbLooged").increment();
        return ResponseEntity.ok().build();
    }
}


// import ovh.ruokki.example.basic.controller.dto.Biere;


// import org.springframework.web.bind.annotation.RequestMapping;


// @RestController
// @RequestMapping("login")
// public class LoginController {
    
//     @GetMapping()
//     public ResponseEntity<Void> login() {
//         return ResponseEntity.ok().build();
//     }
    
    
// }