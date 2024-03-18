package com.Anudip.Hospital_Management.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    private static EntityManagerFactory emf = null;

    static {
        emf = Persistence.createEntityManagerFactory("hospital-management-system");
    }

    public static EntityManager getEntityManagerFactory() {
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
