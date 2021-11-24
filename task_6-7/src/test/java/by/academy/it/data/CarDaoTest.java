package by.academy.it.data;

import by.academy.it.components.Address;
import by.academy.it.pojos.Car;
import by.academy.it.pojos.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CarDaoTest extends BaseTest {


    @Test
    public void testSaveCarWithIdentifier() {
        //Given
        Car audi = new Car();
        audi.setModel("Audi a5");
        audi.setPower(245);
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        CarDao carDao = new CarDao(sessionFactory);

        //When
        Serializable id = carDao.saveCarWithIdentifier(audi);
        tr.commit();

        //Then
        assertNotNull(id);
        assertEquals(id,session.get(Car.class, id).getId());
        System.out.println("Car id : " + id);
        session.close();
    }
}