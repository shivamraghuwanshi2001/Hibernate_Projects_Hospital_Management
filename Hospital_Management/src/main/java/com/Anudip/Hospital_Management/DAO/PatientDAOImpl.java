package com.Anudip.Hospital_Management.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.Anudip.Hospital_Management.ENTITY.Patient;
import com.Anudip.Hospital_Management.utility.App;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public void savePatient(Patient patient) {
        EntityManager em = App.getEntityManagerFactory();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(patient);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void updatePatient(Patient patient) {
        EntityManager em = App.getEntityManagerFactory();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(patient);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void deletePatient(long id) {
        EntityManager em = App.getEntityManagerFactory();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Patient patient = em.find(Patient.class, id);
            if (patient != null) {
                em.remove(patient);
            }
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Patient getPatientById(long id) {
        EntityManager em = App.getEntityManagerFactory();
        Patient patient = em.find(Patient.class, id);
        em.close();
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        EntityManager em = App.getEntityManagerFactory();
        List<Patient> patients = em.createQuery("FROM Patient", Patient.class).getResultList();
        em.close();
        return patients;
    }
}

