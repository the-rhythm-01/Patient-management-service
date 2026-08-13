package com.ritam.patientservice.service;

import com.ritam.patientservice.dto.PatientRequestDTO;
import com.ritam.patientservice.dto.PatientResponseDTO;
import com.ritam.patientservice.exception.EmailAlreadyExistsException;
import com.ritam.patientservice.exception.PatientNotFoundException;
import com.ritam.patientservice.mapper.PatientMapper;
import com.ritam.patientservice.model.Patient;
import com.ritam.patientservice.repository.PatientRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class PatientService {
    private PatientRepository patientRepository;
    //Dependency  injection
    public PatientService(PatientRepository patientRepository){
        this.patientRepository= patientRepository;
    }

    //Read Patients
    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();

        return patients.stream().map(patient -> PatientMapper.toDTO(patient)).toList();
    }

    //Create Patient
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with the email " + patientRequestDTO.getEmail() + " galready exists!");
        }
        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));

        return PatientMapper.toDTO(newPatient);
    }

    //Update Patient
    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO){
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient with id: "+id+" can't be found."));
        if(patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(), id)){
            throw new EmailAlreadyExistsException(
                    "A patient with the email " + patientRequestDTO.getEmail() + " already exists!");
        }

        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        Patient updatedPatient = patientRepository.save(patient);
        return PatientMapper.toDTO(updatedPatient);
    }

    //Delete patient
    public void deletePatient(UUID id){
        patientRepository.deleteById(id);
    }
}
