package by.academy.it.data;

import by.academy.it.pojos.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class PersonDao {
    private static SessionFactory sessionFactory;

    public PersonDao() {
        sessionFactory = SessionFactoryHolder.getSessionFactory();
    }

    public PersonDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Serializable savePerson(Person person) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(person);
            id = session.getIdentifier(person);
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

    public Person getPerson (Serializable id) {
        Session session = sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        return person;
    }
}
