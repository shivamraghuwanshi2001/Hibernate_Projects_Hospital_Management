package com.Anudip.Hospital_Management.ENTITY;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String specialization;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments;
    
    
  //getters, and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	
    // Constructors
	
	public Doctor(long id, String name, String specialization, Set<Appointment> appointments) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.appointments = appointments;
	}
	
	

	public Doctor(String name, String specialization, Set<Appointment> appointments) {
		super();
		this.name = name;
		this.specialization = specialization;
		this.appointments = appointments;
	}
	
	

	public Doctor(String name, String specialization) {
		super();
		this.name = name;
		this.specialization = specialization;
	}

	public Doctor() {
		super();
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", appointments="
				+ appointments + "]";
	}
	
	

	
    
    
    
}