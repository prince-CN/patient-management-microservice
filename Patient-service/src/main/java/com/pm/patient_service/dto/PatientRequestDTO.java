package com.pm.patient_service.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientRequestDTO {
    @NotBlank
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    @NotBlank
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank
    private String address;

    @NotBlank
    private String dateOfBirth;

    private String firstName;
    private String lastName;
    private LocalDate registeredDate;
}
