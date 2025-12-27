package com.pm.patient_service.dto;

import java.time.LocalDate;

public class PatientResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private java.time.LocalDate dateOfBirth;
    private java.time.LocalDate registeredDate;

    // getters
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public LocalDate getRegisteredDate() { return registeredDate; }

    // setters
    public void setId(Long id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setAddress(String address) { this.address = address; }
    public void setDateOfBirth(java.time.LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public void setRegisteredDate(java.time.LocalDate registeredDate) { this.registeredDate = registeredDate; }
}
