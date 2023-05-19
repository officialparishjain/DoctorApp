package com.parishjain.HospitalManagementSystem.service;

import com.parishjain.HospitalManagementSystem.models.Doctor;
import com.parishjain.HospitalManagementSystem.repository.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    IDoctorRepo iDoctorRepo;


    // SAVING THE DOCTOR
    public String addDoctor(Doctor doctor) {
        iDoctorRepo.save(doctor);
        return "Doctor saved successfully...";
    }

    List<Doctor> getAllDoctors() {
       List<Doctor> allDoctors =  iDoctorRepo.findAll();
       return allDoctors;
    }
}
