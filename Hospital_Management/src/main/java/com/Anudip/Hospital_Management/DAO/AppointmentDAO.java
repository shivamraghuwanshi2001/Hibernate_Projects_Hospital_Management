package com.Anudip.Hospital_Management.DAO;

import java.util.List;

import com.Anudip.Hospital_Management.ENTITY.Appointment;

public interface AppointmentDAO {
    void saveAppointment(Appointment appointment);
    void updateAppointment(Appointment appointment);
    void deleteAppointment(long id);
    Appointment getAppointmentById(long id);
    List<Appointment> getAllAppointments();
}