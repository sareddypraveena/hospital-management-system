package com.org.Service;



import com.org.Entity.Doctor;
import com.org.Repositry.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Create doctor
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Get doctor by ID
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Doctor not found with id: " + id));
    }

    // Update doctor
    public Doctor updateDoctor(Long id, Doctor doctor) {

        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Doctor not found with id: " + id));

        existingDoctor.setFirstName(doctor.getFirstName());
        existingDoctor.setLastName(doctor.getLastName());
        existingDoctor.setSpecialization(doctor.getSpecialization());
        existingDoctor.setEmail(doctor.getEmail());
        existingDoctor.setPhone(doctor.getPhone());
        existingDoctor.setGender(doctor.getGender());
        existingDoctor.setExperience(doctor.getExperience());
        existingDoctor.setQualification(doctor.getQualification());

        return doctorRepository.save(existingDoctor);
    }

    // Delete doctor
    public void deleteDoctor(Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Doctor not found with id: " + id));

        doctorRepository.delete(doctor);
    }
}