package com.Anudip.Hospital_Management.UI;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.Anudip.Hospital_Management.ENTITY.Appointment;
import com.Anudip.Hospital_Management.ENTITY.Doctor;
import com.Anudip.Hospital_Management.ENTITY.Patient;
import com.Anudip.Hospital_Management.SERVICE.AppointmentService;
import com.Anudip.Hospital_Management.SERVICE.AppointmentServiceImpl;
import com.Anudip.Hospital_Management.SERVICE.DoctorService;
import com.Anudip.Hospital_Management.SERVICE.DoctorServiceImpl;
import com.Anudip.Hospital_Management.SERVICE.PatientService;
import com.Anudip.Hospital_Management.SERVICE.PatientServiceImpl;
import com.Anudip.Hospital_Management.DAO.AppointmentDAOImpl;
import com.Anudip.Hospital_Management.DAO.DoctorDAOImpl;
import com.Anudip.Hospital_Management.DAO.PatientDAOImpl;

public class HospitalManagementApp {
    private static Scanner sc = new Scanner(System.in);
    private static AppointmentService apService = new AppointmentServiceImpl(new AppointmentDAOImpl());
    private static DoctorService dtrService = new DoctorServiceImpl(new DoctorDAOImpl());
    private static PatientService pntService = new PatientServiceImpl(new PatientDAOImpl());

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Book Appointment");
            System.out.println("2. Update Appointment");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Register Doctor");
            System.out.println("5. Update Doctor");
            System.out.println("6. Remove Doctor");
            System.out.println("7. Register Patient");
            System.out.println("8. Update Patient");
            System.out.println("9. Remove Patient");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bookAppointment();
                    break;
                case 2:
                    updateAppointment();
                    break;
                case 3:
                    cancelAppointment();
                    break;
                case 4:
                    registerDoctor();
                    break;
                case 5:
                    updateDoctor();
                    break;
                case 6:
                    removeDoctor();
                    break;
                case 7:
                    registerPatient();
                    break;
                case 8:
                    updatePatient();
                    break;
                case 9:
                    removePatient();
                    break;
                case 10:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 10);
        sc.close();
    }

    private static void bookAppointment() {
        // Input appointment details from the user
        System.out.println("Enter patient ID:");
        long patientId = sc.nextLong();
        System.out.println("Enter doctor ID:");
        long doctorId = sc.nextLong();
        
        System.out.println("Enter appointment date and time (YYYY-MM-DD HH:mm):");
        String dateTimeInput = sc.nextLine(); // Consume the newline character
        dateTimeInput = sc.nextLine(); // Read the actual input

        // Parse the input date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date appointmentDateTime = null;
        try {
            appointmentDateTime = dateFormat.parse(dateTimeInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format! Please enter the date and time in the format YYYY-MM-DD HH:mm");
            return; // Exit the method if the date format is invalid
        }

        // Create an appointment object with the input details
        Appointment appointment = new Appointment(patientId, doctorId, appointmentDateTime);

        // Call the service to book the appointment
        apService.bookAppointment(appointment);
        System.out.println("Appointment booked successfully!");
    }



    private static void updateAppointment() {
        System.out.println("Enter patient ID:");
        long patientId = sc.nextLong();
        System.out.println("Enter doctor ID:");
        long doctorId = sc.nextLong();
        
        // Create an appointment object with the input details
        Appointment appointment = new Appointment(patientId, doctorId);

        // Call the service to update the appointment
        apService.updateAppointment(appointment);
        System.out.println("Appointment updated successfully!");
    }

    private static void cancelAppointment() {
        // Implement logic to cancel an appointment
        System.out.println("Enter patient ID:");
        long patientId = sc.nextLong();
        System.out.println("Enter doctor ID:");
        long doctorId = sc.nextLong();

        // Call the service to cancel the appointment
        apService.cancelAppointment(patientId); 
        System.out.println("Appointment canceled successfully!");
    }

    private static void registerDoctor() {
        // Gather doctor details from user input
        System.out.println("Enter Doctor Specialization:");
        String doctorSpecialization = sc.next();
        System.out.println("Enter Doctor Name:");
        String doctorName = sc.next();
        // Add more fields as required

        // Create a Doctor object with the input details
        Doctor doctor = new Doctor(doctorName, doctorSpecialization);
        // Call the service to register the doctor
        dtrService.registerDoctor(doctor); 

        System.out.println("Doctor registered successfully!");
    }

    private static void updateDoctor() {
        // Gather doctor details from user input
        System.out.println("Enter Doctor ID to update:");
        long doctorId = sc.nextLong();
        System.out.println("Enter Updated Doctor Name:");
        String updatedName = sc.next();
        // Add more fields as required
        System.out.println("Enter Updated Doctor Specialization:");
        String updatedSpecialization=sc.next();

        // Fetch the existing doctor from the database
        Doctor existingDoctor = dtrService.getDoctorById(doctorId);
        if (existingDoctor != null) {
            // Update the doctor details
            existingDoctor.setName(updatedName);
            // Update more fields as required
            existingDoctor.setSpecialization(updatedName);
            // Call the service to update the doctor
            dtrService.updateDoctor(existingDoctor); 

            System.out.println("Doctor updated successfully!");
        } else {
            System.out.println("Doctor not found!");
        }
    }

    private static void removeDoctor() {
        // Gather doctor ID from user input
        System.out.println("Enter Doctor ID to remove:");
        long doctorId = sc.nextLong();

        // Call the service to remove the doctor
        dtrService.removeDoctor(doctorId); 

        System.out.println("Doctor removed successfully!");
    }

    private static void registerPatient() {
        // Gather patient details from user input
        sc.nextLine();
        System.out.println("Enter Patient Name:");
        String patientName = sc.nextLine();
        System.out.println("Enter date of birth of patient (YYYY-MM-DD):");
        String dateOfBirth = sc.nextLine();
        System.out.println("Enter Gender of Patient 'M' for male and 'F' for Female:");
        String gender = sc.nextLine();

        // Create a Patient object with the input details
        Patient patient = new Patient(patientName, dateOfBirth, gender);

        // Call the service to register the patient
        pntService.registerPatient(patient); 

        System.out.println("Patient registered successfully!");
    }


    private static void updatePatient() {
        // Gather patient details from user input
        System.out.println("Enter Patient ID to update:");
        long patientId = sc.nextLong();
        System.out.println("Enter Updated Patient Name:");
        String updatedName = sc.next();
        System.out.println("Enter Updated Date of Birth:");
        String updatedDateOfBirth = sc.next();
        System.out.println("Enter Updated Gender ('M' for male and 'F' for Female):");
        String updatedGender = sc.next();

        // Fetch the existing patient from the database
        Patient existingPatient = pntService.getPatientById(patientId);
        if (existingPatient != null) {
        	
            // Update the patient details
            existingPatient.setName(updatedName);
            existingPatient.setDateOfBirth(updatedDateOfBirth);
            existingPatient.setGender(updatedGender);
            
            // Call the service to update the patient
            pntService.updatePatient(existingPatient); 

            System.out.println("Patient updated successfully!");
        } else {
            System.out.println("Patient not found!");
        }
    }


    private static void removePatient() {
        // Gather patient ID from user input
        System.out.println("Enter Patient ID to remove:");
        long patientId = sc.nextLong();

        // Call the service to remove the patient
        pntService.removePatient(patientId); 

        System.out.println("Patient removed successfully!");
    }

}
