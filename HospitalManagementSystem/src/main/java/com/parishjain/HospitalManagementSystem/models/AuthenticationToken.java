package com.parishjain.HospitalManagementSystem.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

    @Entity
    @Data
    @NoArgsConstructor
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String token;
    private LocalDate tokenCreationDate;

    @OneToOne
    @JoinColumn(nullable = false,name = "fk_patient_ID")
    private Patient patient;


    public AuthenticationToken(Patient patient) {
        this.patient = patient;
        this.tokenCreationDate = LocalDate.now();
        /*
            This line of code generates a random unique identifier using the UUID class in Java.
            UUID stands for "Universally Unique Identifier" and is a standardized way of generating unique IDs.
            The randomUUID() method generates a type 4 UUID, which is generated from random or pseudo-random numbers.
            The toString() method converts the generated UUID into a String representation.
            In summary, the line of code generates a random string that can be used as a unique identifier for an object,
            transaction, or any other purpose that requires a unique identifier.
         */
        this.token = UUID.randomUUID().toString();
    }

}
