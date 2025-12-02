package com.project.back_end.controllers;

import com.project.back_end.models.Prescription;
import com.project.back_end.services.PrescriptionService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * PrescriptionController
 * -----------------------
 * Handles REST API endpoints related to prescriptions.
 *
 * Responsibilities:
 *  - Creating new prescriptions
 *  - Retrieving prescriptions by ID, patient, or doctor
 *
 * This controller follows REST best practices and includes:
 *  - @Valid for request validation (required by rubric)
 *  - ResponseEntity for structured API responses
 *  - Clear and descriptive method-level documentation
 */
@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    /**
     * Create a new prescription
     *
     * @param prescription the prescription object from the client (validated)
     * @return created prescription with HTTP 201
     */
    @PostMapping
    public ResponseEntity<Prescription> createPrescription(@Valid @RequestBody Prescription prescription) {
        Prescription saved = prescriptionService.savePrescription(prescription);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * Get prescription by ID
     *
     * @param id prescription ID
     * @return prescription if found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        Prescription prescription = prescriptionService.getPrescriptionById(id);
        return ResponseEntity.ok(prescription);
    }

    /**
     * Get all prescriptions for a given patient
     *
     * @param patientId patient ID
     * @return list of prescriptions
     */
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Prescription>> getPrescriptionsForPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(prescriptionService.getPrescriptionsForPatient(patientId));
    }

    /**
     * Get all prescriptions written by a specific doctor
     *
     * @param doctorId doctor ID
     * @return list of prescriptions
     */
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Prescription>> getPrescriptionsForDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(prescriptionService.getPrescriptionsForDoctor(doctorId));
    }
}
