package com.parishjain.HospitalManagementSystem.controller;

import com.parishjain.HospitalManagementSystem.models.Doctor;
import com.parishjain.HospitalManagementSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping(value = "/add")
    String addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }
}
