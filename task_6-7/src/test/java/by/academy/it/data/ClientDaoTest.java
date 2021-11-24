package by.academy.it.data;

import by.academy.it.components.Address;
import by.academy.it.pojos.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClientDaoTest extends BaseTest {

    @Test
    public void testSaveClientWithIdentifier() {
        //Given
        Address address = new Address();
        address.setCity("Minsk");
        address.setStreet("Lenina");
        address.setPostalCode("222153");

        Client alex = new Client();
        alex.setName("Alex");
        alex.setSurname("Ivanov");
        alex.setAge(35);
        alex.setAddress(address);
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        ClientDao clientDao = new ClientDao(sessionFactory);

        //When
        Serializable id = clientDao.saveClientWithIdentifier(alex);
        tr.commit();

        //Then
        assertNotNull(alex);
        assertEquals(id,session.get(Client.class, id).getId());
        assertEquals(address.toString(), session.get(Client.class, id).getAddress().toString());
        System.out.println("Client id : " + id);
        System.out.println(session.get(Client.class, id));
        session.close();
    }
}