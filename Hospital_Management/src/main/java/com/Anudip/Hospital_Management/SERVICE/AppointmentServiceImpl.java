package com.Anudip.Hospital_Management.SERVICE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Anudip.Hospital_Management.DAO.AppointmentDAO;
import com.Anudip.Hospital_Management.ENTITY.Appointment;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    
    private AppointmentDAO appointmentDAO;
    @Autowired
    public AppointmentServiceImpl(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    @Override
    public void bookAppointment(Appointment appointment) {
        appointmentDAO.saveAppointment(appointment);
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        appointmentDAO.updateAppointment(appointment);
    }

    @Override
    public void cancelAppointment(long id) {
        appointmentDAO.deleteAppointment(id);
    }

    @Override
    public Appointment getAppointmentById(long id) {
        return appointmentDAO.getAppointmentById(id);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }
}