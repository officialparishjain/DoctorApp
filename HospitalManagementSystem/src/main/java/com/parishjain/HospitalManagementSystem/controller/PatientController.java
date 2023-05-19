package com.parishjain.HospitalManagementSystem.controller;


import com.parishjain.HospitalManagementSystem.dto.SignInInput;
import com.parishjain.HospitalManagementSystem.dto.SignInOutput;
import com.parishjain.HospitalManagementSystem.dto.SignUpInput;
import com.parishjain.HospitalManagementSystem.dto.SignUpOutput;
import com.parishjain.HospitalManagementSystem.models.Doctor;
import com.parishjain.HospitalManagementSystem.service.AuthenticationService;
import com.parishjain.HospitalManagementSystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {


    @Autowired
    PatientService patientService;

    @Autowired
    AuthenticationService authService;

    // SIGN UP
    @PostMapping(value = "/signup")
    public SignUpOutput signup(@RequestBody SignUpInput signUpDto){
        return patientService.signup(signUpDto);
    }

    // SIGN IN
    @PostMapping(value = "/signin")
    public SignInOutput signin(@RequestBody SignInInput signInDto) {
        return patientService.signin(signInDto);
    }

    // PATIENT WANT TO SEE ALL DOCTORS
    @GetMapping(value = "/doctors")
    ResponseEntity<List<Doctor>> getAllDoctors(@RequestParam String userEmail, @RequestParam String token){

        HttpStatus status;
        List<Doctor> allDoctors = null;

        // AUTHENTICATE

        if(authService.authenticate(userEmail,token)){
            allDoctors = patientService.fetchAllDoctors();
            status = HttpStatus.OK;
        }
        else{
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<List<Doctor>>(allDoctors,status);
    }
}
