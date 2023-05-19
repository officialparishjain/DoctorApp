package com.parishjain.HospitalManagementSystem.service;

import com.parishjain.HospitalManagementSystem.repository.IAppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    IAppointmentRepo appointmentRepo;
}
