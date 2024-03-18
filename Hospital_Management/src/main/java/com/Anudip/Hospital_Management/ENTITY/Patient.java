package com.Anudip.Hospital_Management.ENTITY;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String dateOfBirth;

    @Column(nullable = false)
    private String gender;

    @OneToMany(mappedBy = "patient")
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	
	
	 // Constructors, 
	
	public Patient(long id, String name, String dateOfBirth, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		
	}
	

	public Patient(String name, String dateOfBirth, String gender, Set<Appointment> appointments) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.appointments = appointments;
	}
	
	 public Patient(String name, String dateOfBirth, String gender) {
	        this.name = name;
	        this.dateOfBirth = dateOfBirth;
	        this.gender = gender;
	    }

	public Patient() {
		super();
	}

   
    
    
    
   
}