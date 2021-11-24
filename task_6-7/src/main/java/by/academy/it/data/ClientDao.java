package by.academy.it.data;

import by.academy.it.pojos.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class ClientDao {
    private static SessionFactory sessionFactory;

    public ClientDao() {
        sessionFactory = SessionFactoryHolder.getSessionFactory();
    }

    public ClientDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Serializable saveClientWithIdentifier(Client client) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(client);
            id = session.getIdentifier(client);
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
