package com.parishjain.HospitalManagementSystem.service;

import com.parishjain.HospitalManagementSystem.dto.SignInInput;
import com.parishjain.HospitalManagementSystem.dto.SignInOutput;
import com.parishjain.HospitalManagementSystem.dto.SignUpInput;
import com.parishjain.HospitalManagementSystem.dto.SignUpOutput;
import com.parishjain.HospitalManagementSystem.models.AuthenticationToken;
import com.parishjain.HospitalManagementSystem.models.Doctor;
import com.parishjain.HospitalManagementSystem.models.Patient;
import com.parishjain.HospitalManagementSystem.repository.PatientRepository;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import jakarta.xml.bind.DatatypeConverter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AuthenticationService tokenService;

    @Autowired
    DoctorService doctorService;

    public SignUpOutput signup(SignUpInput signUpDto) {


        // CHECK IF USER EXIST OR NOT BY EMAIL
       Patient patient = patientRepository.findFirstByPatientEmail(signUpDto.getUserEmail());
       if(patient != null){
           // MEANS IT IS OLD USER THAT'S WHY IT COME TO THIS SECTION
           // SO HERE WE HAVE TO THROW EXCEPTION
           throw new IllegalStateException("Patient already exist ... Sign in instead...");
       }


        // ENCRYPTION
        String encryptPassword = null;
           try{
                encryptPassword = generateEncryptPassword(signUpDto.getUserPassword());
           }
           catch(Exception ex){
                ex.printStackTrace();
           }

        // SAVE THE USER
        patient = new Patient(signUpDto.getUserFirstName(),signUpDto.getUserLastName(),
                signUpDto.getUserEmail(),encryptPassword,signUpDto.getUserContact());

        patientRepository.save(patient);

        // TOKEN CREATION AND SAVING

        AuthenticationToken token = new AuthenticationToken(patient);

        tokenService.saveToken(token);

        return new SignUpOutput("Patient registered","Patient created successfully");


    }

    private String generateEncryptPassword(String userPassword) throws NoSuchAlgorithmException {
        // Create a new instance of the MD5 message digest
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // Get the user's password as a byte array and update the message digest with it
        md5.update(userPassword.getBytes());
                // Calculate the MD5 hash of the password
                byte[] digested = md5.digest();
        // Convert the byte array to a hexadecimal string
        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SignInOutput signin(SignInInput signInDto) {

        // CHECK USER EXIST OR NOT
        Patient patient = patientRepository.findFirstByPatientEmail(signInDto.getPatientEmail());

        if(patient == null){
            throw new IllegalStateException("Kindly check email and password again");
        }

        // ENCRYPT THE PASSWORD
        String encryptedPassword =  null;
        try{
            encryptedPassword = generateEncryptPassword(signInDto.getPatientPassword());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        // MATCH IT WITH DATABASE ENCRYPTED PASSWORD
        boolean isPasswordValid = encryptedPassword.equals(patient.getPatientPassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        //figure out the token

        AuthenticationToken authenticationToken = tokenService.getToken(patient);
        //set up output response

        return new SignInOutput("Authentication Successfull !!!",authenticationToken.getToken());


    }


    // Because actual logic should not be in Patient Service that;s why here we will
    // write actual business logic in DoctorService
    public List<Doctor>     fetchAllDoctors() {
        return doctorService.getAllDoctors();
    }
}
