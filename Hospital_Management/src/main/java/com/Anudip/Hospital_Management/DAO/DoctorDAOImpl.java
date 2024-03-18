package com.Anudip.Hospital_Management.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.Anudip.Hospital_Management.ENTITY.Doctor;
import com.Anudip.Hospital_Management.utility.App;

public class DoctorDAOImpl implements DoctorDAO {
   
    @Override
    public void saveDoctor(Doctor doctor) {
        EntityManager em = App.getEntityManagerFactory();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(doctor);
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
    public void updateDoctor(Doctor doctor) {
        EntityManager em = App.getEntityManagerFactory();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(doctor);
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
    public void deleteDoctor(long id) {
        EntityManager em = App.getEntityManagerFactory();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Doctor doctor = em.find(Doctor.class, id);
            if (doctor != null) {
                em.remove(doctor);
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
    public Doctor getDoctorById(long id) {
        EntityManager em = App.getEntityManagerFactory();
        Doctor doctor = em.find(Doctor.class, id);
        em.close();
        return doctor;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        EntityManager em = App.getEntityManagerFactory();
        List<Doctor> doctors = em.createQuery("FROM Doctor", Doctor.class).getResultList();
        em.close();
        return doctors;
    }
}
