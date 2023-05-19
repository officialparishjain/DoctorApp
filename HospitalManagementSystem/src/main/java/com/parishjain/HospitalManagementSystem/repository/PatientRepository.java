package com.parishjain.HospitalManagementSystem.repository;

import com.parishjain.HospitalManagementSystem.models.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Long> {

    Patient findFirstByPatientEmail(String Email);
}
