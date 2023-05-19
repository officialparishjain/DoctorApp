package com.parishjain.HospitalManagementSystem.repository;

import com.parishjain.HospitalManagementSystem.models.AuthenticationToken;
import com.parishjain.HospitalManagementSystem.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepo extends JpaRepository<AuthenticationToken, Long> {

    AuthenticationToken findByPatient(Patient patient);

    AuthenticationToken findFirstByToken(String token);
}
