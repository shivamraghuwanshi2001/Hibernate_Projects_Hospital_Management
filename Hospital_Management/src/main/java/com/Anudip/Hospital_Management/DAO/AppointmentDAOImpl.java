package com.Anudip.Hospital_Management.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

import com.Anudip.Hospital_Management.ENTITY.Appointment;
import com.Anudip.Hospital_Management.utility.App;

public class AppointmentDAOImpl implements AppointmentDAO {

    @Override
    public void saveAppointment(Appointment appointment) {
        EntityManager em = App.getEntityManagerFactory();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(appointment);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        EntityManager em = App.getEntityManagerFactory();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(appointment);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteAppointment(long id) {
        EntityManager em = App.getEntityManagerFactory();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Appointment appointment = em.find(Appointment.class, id);
            if (appointment != null) {
                em.remove(appointment);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Appointment getAppointmentById(long id) {
        EntityManager em = App.getEntityManagerFactory();
        try {
            return em.find(Appointment.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Appointment> getAllAppointments() {
        EntityManager em = App.getEntityManagerFactory();
        try {
            TypedQuery<Appointment> query = em.createQuery("SELECT a FROM Appointment a", Appointment.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
