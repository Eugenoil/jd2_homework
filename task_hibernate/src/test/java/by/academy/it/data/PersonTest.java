package by.academy.it.data;

import by.academy.it.pojos.Person;
import junit.framework.TestCase;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;


import static org.junit.Assert.*;

import java.io.Serializable;

public class PersonTest {

    static  SessionFactory sessionFactory;


    @BeforeClass
    public static void init() {
        StandardServiceRegistry reg =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.persons.cfg-test.xml")// hibernate-test.cfg.xml
                        .build();

        sessionFactory = new MetadataSources(reg)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Test
    public void testSavePerson() {
        //Given
        Person person = new Person();
        person.setName("Eugene");
        person.setSurname("Dunin");
        person.setAge(23);
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();

        //When
        Serializable id = session.save(person);
        tr.commit();


        //Then
        assertNotNull(id);
        assertNotNull(session.get(Person.class, id));
        session.delete(person);
        session.close();

    }


    @Test
    public void TestFindPerson() {
        //Given
        Person person = new Person();
        person.setName("Eugene");
        person.setSurname("Dunin");
        person.setAge(23);
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();

        //When
        Serializable id = session.save(person);
        Person saved = session.get(Person.class, id);
        tr.commit();


        //Then
        assertEquals(saved, person);
        session.close();
    }
}