package pl.sdacademy.hibernate.management.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtils {

    // TODO: 0. Utworzyć bazę dla projektu na MySql
    //           np. university-managment

    // TODO: 1. Skonfigurować w hibernate.cfg.xml połączenie do utworzonej bazy danych

    // TODO: 2. Zaimplementować wczytanie konfiguracji z pliku hibernate.cfg.xml SessionFactory


    private HibernateUtils(){
        throw new IllegalStateException("Utility class");
    }

    private static  SessionFactory SESSION_FACTORY;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder() {
            }
                    .applySettings(configuration.getProperties())
                    .build();

            SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
        }catch (Exception ex){
            System.err.println("Sessiob Factory could not be created");
        }
    }




    public static SessionFactory getSessionFactory() {


        return SESSION_FACTORY;


    }
}
