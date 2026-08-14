package com.ritam.patientservice.controller;

import com.ritam.patientservice.dto.PatientRequestDTO;
import com.ritam.patientservice.dto.PatientResponseDTO;
import com.ritam.patientservice.dto.validators.CreatePatientValidationGroup;
import com.ritam.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patient Management", description = "This API helps to manage patients")
public class PatientController {
    private final PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary = "Get Patients")
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){
        List<PatientResponseDTO> patients = patientService.getPatients();

        return ResponseEntity.ok().body(patients);
    }

    @PostMapping
    @Operation(summary = "Create new patient")
    public ResponseEntity<PatientResponseDTO> createPatient(
            @Validated({Default.class, CreatePatientValidationGroup.class})
            @RequestBody PatientRequestDTO patientRequestDTO){
        PatientResponseDTO patient = patientService.createPatient(patientRequestDTO);

        return ResponseEntity.ok().body(patient);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update patient using ID")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id, @RequestBody @Valid PatientRequestDTO patientRequestDTO){
        PatientResponseDTO patient = patientService.updatePatient(id, patientRequestDTO);

        return ResponseEntity.ok().body(patient);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete patient using ID")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id){
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
