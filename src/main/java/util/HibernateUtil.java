package util;

import entities.ContactTypeEntity;
import entities.ContactsEntity;
import entities.PersonEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {


    //  A variable for getting a session object
    private static final SessionFactory sessionFactory;

    static {
        try {
            //  Create conf file for working with hibernates
            Configuration configuration = new Configuration();
            //  Path for hibernate config
            configuration.configure("hibernate.cfg.xml");
            //  Specifying the classes that contain entities
            configuration.addAnnotatedClass(ContactsEntity.class);
            configuration.addAnnotatedClass(ContactTypeEntity.class);
            configuration.addAnnotatedClass(PersonEntity.class);
            //  getting a factory for instances of the Session class
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            // Make exception
            throw new ExceptionInInitializerError(ex);
        }
    }

    //  Getter for sessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

