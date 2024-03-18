package com.Anudip.Hospital_Management.DAO;

import java.util.List;

import com.Anudip.Hospital_Management.ENTITY.Patient;

public interface PatientDAO {
    void savePatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(long id);
    Patient getPatientById(long id);
    List<Patient> getAllPatients();
}
