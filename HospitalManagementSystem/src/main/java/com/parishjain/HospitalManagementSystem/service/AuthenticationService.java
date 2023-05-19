package com.parishjain.HospitalManagementSystem.service;

import com.parishjain.HospitalManagementSystem.models.AuthenticationToken;
import com.parishjain.HospitalManagementSystem.models.Patient;
import com.parishjain.HospitalManagementSystem.repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    ITokenRepo itokenRepo;

    public void saveToken(AuthenticationToken token)
    {
        itokenRepo.save(token);
    }
    public AuthenticationToken getToken(Patient patient) {
        return itokenRepo.findByPatient(patient);
    }


    public boolean authenticate(String userEmail, String token) {
        AuthenticationToken authenticationToken = itokenRepo.findFirstByToken(token);
        String expectedMail = authenticationToken.getPatient().getPatientEmail();
        return expectedMail.equals(userEmail);
    }
}
