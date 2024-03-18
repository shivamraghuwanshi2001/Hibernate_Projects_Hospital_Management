package com.Anudip.Hospital_Management.ENTITY;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(nullable = false)
    private Date appointmentDateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getAppointmentDateTime() {
		return appointmentDateTime;
	}

	public void setAppointmentDateTime(Date appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}

	public Appointment(long id, Doctor doctor, Patient patient, Date appointmentDateTime) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.patient = patient;
		this.appointmentDateTime = appointmentDateTime;
	}

	public Appointment() {
		super();
	}
	
	public Appointment(Doctor doctor, Patient patient, Date appointmentDateTime) {
	    this.doctor = doctor;
	    this.patient = patient;
	    this.appointmentDateTime = appointmentDateTime;
	}

    
    
}