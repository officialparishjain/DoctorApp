package com.parishjain.HospitalManagementSystem.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long patientId;
    private String patientFirstName;
    private String patientLastName;
    private String patientEmail;

    private String patientPassword;
    private  String patientContact;

    @OneToOne(mappedBy = "patient")
    private Appointment appointment;

    public Patient(String patientFirstName, String patientLastName, String patientEmail, String patientPassword, String patientContact) {
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientEmail = patientEmail;
        this.patientPassword = patientPassword;
        this.patientContact = patientContact;
    }
}
