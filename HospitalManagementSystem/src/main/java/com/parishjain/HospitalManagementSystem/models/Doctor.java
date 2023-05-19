package com.parishjain.HospitalManagementSystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class  Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String doctorName;
    private String doctorExperience;
    @Enumerated(EnumType.STRING)
    private Specialization doctorSpecialization;
    private String doctorContact;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;


}
