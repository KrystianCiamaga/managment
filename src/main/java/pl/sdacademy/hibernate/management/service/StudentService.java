package pl.sdacademy.hibernate.management.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.sdacademy.hibernate.management.model.Student;
import pl.sdacademy.hibernate.management.util.HibernateUtils;

import java.util.List;

public class StudentService {

    // TODO: 3a Zaimplementować service wraz z następującymi metodami:
    //findById, findAll, findById, findByPESEL, create, update, delete

    // TODO: 3b Stworzyć test sprawdzający powyższe metody


    private SessionFactory sessionFactory;

    public StudentService() {
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }


    public List<Student> findAll() {


        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("select s from Student s order by s.lastName");

        List<Student> list = query.list();


        transaction.commit();
        session.close();


        return list;
    }


   public Student findById(int id) {

        Session session=sessionFactory.openSession();
       Transaction transaction = session.beginTransaction();

       Student student = (Student)session.get(Student.class, id);


       transaction.commit();
       session.close();

       return student;
   }

    public Student findByPesel(String pesel) {

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Query query = session.createQuery("select s from Student s where s.pesel=:pesel");
        query.setParameter("pesel",pesel);

        List<Student> list = query.list();

        transaction.commit();
        session.close();

        if(list.isEmpty()){
            return null;
        }else
            return list.get(0);

    }

    public int create(String firstName, String lastName, String pesel, String section) {


        Student student = new Student(firstName, lastName, section, pesel);

        Session session = HibernateUtils.getSessionFactory().openSession();

        session.beginTransaction();

        session.persist(student);

        session.getTransaction().commit();

        session.close();


        return 1;

    }

    public int save(Student student) {

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Integer id=(Integer)session.save(student);


        transaction.commit();
        session.close();

        return id;

    }




//
    public void update(Student student) {

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        session.update(student);


        transaction.commit();
        session.close();





    }
//
    public void delete(int id) {

        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();

        Query query = session.createQuery("select a from Student a where a.id=:x");
        query.setParameter("x",id);

        List list = query.list();

        session.delete(list.get(0));

        transaction.commit();
        session.close();


    }

}
