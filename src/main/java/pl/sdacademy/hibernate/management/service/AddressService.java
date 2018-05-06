package pl.sdacademy.hibernate.management.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sdacademy.hibernate.management.model.Address;
import pl.sdacademy.hibernate.management.model.Student;
import pl.sdacademy.hibernate.management.util.HibernateUtils;

import java.util.List;

public class AddressService {


    private SessionFactory sessionFactory;


    public AddressService() {
        this.sessionFactory = HibernateUtils.getSessionFactory();

    }


    public void createAddress(String street, String city, String country) {

        Address address = new Address(street, city, country);
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(address);

        transaction.commit();
        session.close();
    }

    public void deleteAddress(int id) {

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete a from Address a  where a.id=:x");
        query.setParameter("x", id);

        List<Student> list = query.list();

        session.delete(list.get(0));


        transaction.commit();
        session.close();


    }


}
