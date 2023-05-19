package com.parishjain.HospitalManagementSystem.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class AppointmentKey implements Serializable  {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appointmentId;
    private LocalDateTime appointmentTime;

}
