package com.project.back_end.repositories;

import com.project.back_end.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for accessing and managing Patient data.
 *
 * <p>This interface provides CRUD operations through JpaRepository and
 * includes custom query methods for retrieving patients by email or
 * phone number, as required by the assignment criteria.</p>
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    /**
     * Retrieves a patient by their email address.
     *
     * @param email the patient's email
     * @return an Optional containing the patient if found
     */
    Optional<Patient> findByEmail(String email);

    /**
     * Retrieves a patient using either their email address or phone number.
     *
     * @param email the patient's email
     * @param phone the patient's phone number
     * @return an Optional containing the patient if either field matches
     */
    Optional<Patient> findByEmailOrPhoneNumber(String email, String phone);
}

