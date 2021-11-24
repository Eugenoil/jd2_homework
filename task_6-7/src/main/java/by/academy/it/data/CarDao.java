package by.academy.it.data;

import by.academy.it.pojos.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class CarDao {

    private static SessionFactory sessionFactory;

    public CarDao() {
        sessionFactory = SessionFactoryHolder.getSessionFactory();
    }

    public CarDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Serializable saveCarWithIdentifier(Car car) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(car);
            id = session.getIdentifier(car);
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

}
