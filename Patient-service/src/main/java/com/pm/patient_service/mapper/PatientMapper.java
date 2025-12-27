package com.pm.patient_service.mapper;

import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.model.Patient;
import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.setId(patient.getId()); // Both should be Long
        dto.setFirstName(patient.getName()); // ya getFirstName() agar field ka naam yeh hai
        dto.setEmail(patient.getEmail());
        dto.setAddress(patient.getAddress());
        dto.setDateOfBirth(patient.getDateOfBirth());
        dto.setRegisteredDate(patient.getRegisteredDate());
        return dto;
    }

    public static Patient toEntity(PatientResponseDTO dto) {
        Patient patient = new Patient();
        patient.setId(dto.getId()); // Both should be Long
        patient.setName(dto.getFirstName()); // ya setFirstName() agar field ka naam yeh hai
        patient.setEmail(dto.getEmail());
        patient.setAddress(dto.getAddress());
        patient.setDateOfBirth(dto.getDateOfBirth());
        // When mapping registeredDate, make sure you use the correct type:
        // Make sure both DTO and entity use LocalDate for registeredDate:
        patient.setRegisteredDate(dto.getRegisteredDate()); // Both must be LocalDate
        return patient;
    }

    public static Patient toEntity(PatientRequestDTO dto) {
        Patient patient = new Patient();
        patient.setName(dto.getFirstName()); // or setFirstName if you have that
        patient.setEmail(dto.getEmail());
        // If dto.getDateOfBirth() returns String, convert it:
        // patient.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
        // If it's already LocalDate:
        // patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setRegisteredDate(dto.getRegisteredDate());
        return patient;
    }
}