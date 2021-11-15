package by.academy.it.data;

import by.academy.it.pojos.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class PersonDao {
    private final SessionFactory sessionFactory;

    public PersonDao() {
        sessionFactory = SessionFactoryHolder.getSessionFactory();
    }

    public Serializable savePerson(Person person) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return id;
    }

    public Person findPersonWithGet(int id) {
        Session session = sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }

    public Person findPersonWithLoad(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Person loadedPerson = null;
        try {
            loadedPerson = session.load(Person.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        if (loadedPerson != null) {
            return loadedPerson;
        } else {
            return null;
        }
    }


    public boolean deletePerson(Serializable id) {
        Session session = sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.delete(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return person != null;
    }

    public void synchronizeWithDatabase(Person person) {
        Session session = sessionFactory.openSession();
        Transaction tr;
        if (person.getCreated() == null) {
            tr = session.beginTransaction();
            session.flush();
            session.refresh(person);
            tr.commit();
        }
        session.close();
    }

    public void createAndDelete(Person person) {
        //When we define Person object at signature, we create new Object in Database
        PersonDao personDao = new PersonDao();
        personDao.savePerson(person);
    }

    public void createAndDelete(Serializable id) {
        //When we define id at signature, we delete the Object from Database
        PersonDao personDao = new PersonDao();
        personDao.deletePerson(id);
    }
}
