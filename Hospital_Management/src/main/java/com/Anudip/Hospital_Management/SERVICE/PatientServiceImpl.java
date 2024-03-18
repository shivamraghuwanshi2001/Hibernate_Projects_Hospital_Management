package com.Anudip.Hospital_Management.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Anudip.Hospital_Management.DAO.PatientDAO;
import com.Anudip.Hospital_Management.ENTITY.Patient;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    private PatientDAO patientDAO; // Removed final modifier

    @Autowired
    public PatientServiceImpl(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public void registerPatient(Patient patient) {
        try {
            patientDAO.savePatient(patient);
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
        }
    }

    @Override
    public void updatePatient(Patient patient) {
        try {
            patientDAO.updatePatient(patient);
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
        }
    }

    @Override
    public void removePatient(long id) {
        try {
            patientDAO.deletePatient(id);
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
        }
    }

    @Override
    public Patient getPatientById(long id) {
        try {
            return patientDAO.getPatientById(id);
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        try {
            return patientDAO.getAllPatients();
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
            return null;
        }
    }
}
