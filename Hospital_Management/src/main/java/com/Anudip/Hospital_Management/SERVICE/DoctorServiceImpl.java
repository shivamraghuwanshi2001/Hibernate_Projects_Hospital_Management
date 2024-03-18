package com.Anudip.Hospital_Management.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Anudip.Hospital_Management.DAO.DoctorDAO;
import com.Anudip.Hospital_Management.ENTITY.Doctor;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private  final DoctorDAO doctorDAO;
    
    public DoctorServiceImpl(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }


    @Override
    public void registerDoctor(Doctor doctor) {
        doctorDAO.saveDoctor(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorDAO.updateDoctor(doctor);
    }

    @Override
    public void removeDoctor(long id) {
        doctorDAO.deleteDoctor(id);
    }

    @Override
    public Doctor getDoctorById(long id) {
        return doctorDAO.getDoctorById(id);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }
}
