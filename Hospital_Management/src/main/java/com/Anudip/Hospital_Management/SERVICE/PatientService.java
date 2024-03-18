package com.Anudip.Hospital_Management.SERVICE;

import java.util.List;

import com.Anudip.Hospital_Management.ENTITY.Patient;

public interface PatientService {
    void registerPatient(Patient patient);
    void updatePatient(Patient patient);
    void removePatient(long id);
    Patient getPatientById(long id);
    List<Patient> getAllPatients();
}