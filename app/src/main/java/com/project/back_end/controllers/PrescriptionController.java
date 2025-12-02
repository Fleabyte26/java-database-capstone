package com.project.back_end.controllers;

import com.project.back_end.models.Prescription;
import com.project.back_end.services.PrescriptionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing prescriptions in the Smart Clinic Management System.
 *
 * <p>This controller exposes endpoints for creating and retrieving prescriptions.
 * It uses ResponseEntity to return structured and meaningful HTTP responses,
 * following best RESTful API practices.</p>
 */
@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    /**
     * Constructor for dependency injection.
     *
     * @param prescriptionService the service handling prescription operations
     */
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    /**
     * Creates a new prescription and saves it to the database.
     *
     * @param prescription the prescription data sent in the request body
     * @return ResponseEntity containing the saved prescription and a CREATED status
     */
    @PostMapping
    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription) {
        Prescription savedPrescription = prescriptionService.savePrescription(prescription);
        return new ResponseEntity<>(savedPrescription, HttpStatus.CREATED);
    }

    /**
     * Retrieves a prescription by its unique ID.
     *
     * @param id the ID of the prescription to retrieve
     * @return ResponseEntity with the prescription if found, or NOT_FOUND if missing
     */
    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        return prescriptionService.getPrescriptionById(id)
                .map(prescription -> new ResponseEntity<>(prescription, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Retrieves all prescriptions stored in the system.
     *
     * @return ResponseEntity containing a list of all prescriptions
     */
    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }
}
