package de.podolak.demo.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dude
 */
public final class EMF {

    private static final String persistenceUnit = "Vaadin_MySQL_JPA_DemoPU";
    
    private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory(persistenceUnit);

    private EMF() {
    }

    public static EntityManagerFactory get() {
        return emfInstance;
    }
}