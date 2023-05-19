package com.parishjain.HospitalManagementSystem.repository;

import com.parishjain.HospitalManagementSystem.models.Appointment;
import com.parishjain.HospitalManagementSystem.models.AppointmentKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepo extends CrudRepository<Appointment, AppointmentKey> {
}
