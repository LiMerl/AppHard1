package com.example.demo.appli.entity;


import io.github.bucket4j.*;

import org.springframework.http.HttpStatus;

import java.time.Duration;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicVaccinationCenterRestControler {

 
    final String remainning = "X-Rate-Limit-Remaining";
    final String retryAfter = "X-Rate-Limit-Retry-After-Seconds";

    @Autowired
    private VaccinationCenterRepository centerRepository;  

     //rajoute 10 tokens toutes les minutes
     Refill refill = Refill.intervally(10, Duration.ofMinutes(1));
     //capacité max de 10 token
     Bandwidth limit = Bandwidth.classic(10, refill);
     Bucket bucket = Bucket.builder().addLimit(limit).build();
 
     @CrossOrigin(exposedHeaders = {remainning, retryAfter})
     @GetMapping(value = "/api/public/center")
     public ResponseEntity<List<VaccinationCenter>> infos() {
 
        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
        if(probe.isConsumed()) {
            return ResponseEntity.ok()
                   
                    .header("X-Rate-Limit-Remaining", Long.toString(probe.getRemainingTokens()))
                    .body(centerRepository.findAll());

        }
        long delaiEnSeconde = probe.getNanosToWaitForRefill() / 1_000_000_000;
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .header("X-Rate-Limit-Retry-After-Seconds", String.valueOf(delaiEnSeconde))
                .build();
    }
 

}
