package com.Anudip.Hospital_Management.SERVICE;
import java.util.List;

import com.Anudip.Hospital_Management.ENTITY.Doctor;

public interface DoctorService {
    void registerDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void removeDoctor(long id);
    Doctor getDoctorById(long id);
    List<Doctor> getAllDoctors();
}