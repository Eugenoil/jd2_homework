package by.academy.it.data;

import by.academy.it.pojos.Employee;
import by.academy.it.pojos.Person;
import by.academy.it.pojos.Student;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonDaoTest extends BaseTest{

    @Test
    public void testSaveEmployee() {
        //Given
        Employee employee = new Employee();
        employee.setName("Ivan");
        employee.setSurname("Petrov");
        employee.setCompany("Epam");
        employee.setSalary(1200.0);
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        PersonDao personDao = new PersonDao(sessionFactory);

        //When
        Serializable id = personDao.savePerson(employee);
        tr.commit();

        //Then
        assertNotNull(id);
        assertEquals(employee.toString(),session.get(Person.class, id).toString());
        session.close();
    }

    @Test
    public void testSaveStudent() {
        //Given
        Student student = new Student();
        student.setName("Vasya");
        student.setSurname("Ptrovich");
        student.setFaculty("SBMT");
        student.setMark(9);
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        PersonDao personDao = new PersonDao(sessionFactory);

        //When
        Serializable id = personDao.savePerson(student);
        tr.commit();

        //Then
        assertNotNull(id);
        assertEquals(student.toString(),session.get(Person.class, id).toString());
        session.close();
    }

    @Test
    public void testGetPerson() {
        //Given
        Employee employee = new Employee();
        employee.setName("Ivan");
        employee.setSurname("Petrov");
        employee.setCompany("Epam");
        employee.setSalary(1200.0);
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        PersonDao personDao = new PersonDao(sessionFactory);
        Serializable id = personDao.savePerson(employee);

        String person = personDao.getPerson(id).toString();
        tr.commit();

        //Then
        assertNotNull(id);
        assertEquals(employee.toString(), person);
        session.close();
    }
}