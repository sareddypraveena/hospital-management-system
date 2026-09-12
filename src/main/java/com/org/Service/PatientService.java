package com.org.Service;




import com.org.Entity.Patient;
import com.org.Repositry.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Create Patient
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Get Patient by ID
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    // Get all Patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Update Patient
    public Patient updatePatient(Long id, Patient patient) {

        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setLastName(patient.getLastName());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setPhone(patient.getPhone());
        existingPatient.setGender(patient.getGender());

        return patientRepository.save(existingPatient);
    }

    // Delete Patient
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}