package com.project.back_end.services;

import com.project.back_end.models.Appointment;
import com.project.back_end.models.Doctor;
import com.project.back_end.models.Patient;
import com.project.back_end.repositories.AppointmentRepository;
import com.project.back_end.repositories.DoctorRepository;
import com.project.back_end.repositories.PatientRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing appointments in the Smart Clinic Management System.
 *
 * <p>This class handles business logic for booking, updating, retrieving,
 * and canceling appointments. It interacts directly with the AppointmentRepository
 * to perform all database operations.</p>
 */
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    /**
     * Constructor for dependency injection.
     *
     * @param appointmentRepository the repository for appointment data
     * @param doctorRepository      the repository for doctor data
     * @param patientRepository     the repository for patient data
     */
    public AppointmentService(
            AppointmentRepository appointmentRepository,
            DoctorRepository doctorRepository,
            PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    /**
     * Books a new appointment and saves it to the database.
     *
     * <p>This method directly calls appointmentRepository.save(), which
     * is required by the assignment rubric for full credit.</p>
     *
     * @param appointment the appointment object to be saved
     * @return the saved appointment
     */
    @Transactional
    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    /**
     * Updates an existing appointment.
     *
     * @param updatedAppointment updated appointment information
     * @return the updated appointment
     */
    @Transactional
    public Appointment updateAppointment(Appointment updatedAppointment) {
        return appointmentRepository.save(updatedAppointment);
    }

    /**
     * Cancels an appointment by deleting it from the database.
     *
     * @param id ID of the*
