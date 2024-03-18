package com.Anudip.Hospital_Management.SERVICE;

import java.util.List;

import com.Anudip.Hospital_Management.ENTITY.Appointment;

public interface AppointmentService {
    void bookAppointment(Appointment appointment);
    void updateAppointment(Appointment appointment);
    void cancelAppointment(long id);
    Appointment getAppointmentById(long id);
    List<Appointment> getAllAppointments();
}
