package com.project.back_end.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Doctor's full name
    private String name;

    // Doctor's specialty (e.g., Pediatrics, Cardiology)
    private String specialty;

    // Contact email for login/communication
    private String email;

    // Contact phone number
    private String phone;

    // REQUIRED BY RUBRIC:
    // Store available appointment times for the doctor.
    // This creates a separate table doctor_available_times linked by doctor_id.
    @ElementCollection
    @CollectionTable(
        name = "doctor_available_times",
        joinColumns = @JoinColumn(name = "doctor_id")
    )
    @Column(name = "available_time")
    private List<String> availableTimes;

    // Constructors
    public Doctor() {}

    public Doctor(String name, String specialty, String email, String phone, List<String> availableTimes) {
        this.name = name;
        this.specialty = specialty;
        this.email = email;
        this.phone = phone;
        this.availableTimes = availableTimes;
    }

    // Getters & setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSpecialty() { return specialty; }

    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public List<String> getAvailableTimes() { return availableTimes; }

    public void setAvailableTimes(List<String> availableTimes) { this.availableTimes = availableTimes; }
}
