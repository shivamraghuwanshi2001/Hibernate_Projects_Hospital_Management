package com.Anudip.Hospital_Management.DAO;

import java.util.List;

import com.Anudip.Hospital_Management.ENTITY.Doctor;

public interface DoctorDAO {
    void saveDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(long id);
    Doctor getDoctorById(long id);
    List<Doctor> getAllDoctors();
}