package by.academy.it.data;

import by.academy.it.dto.Expense;
import by.academy.it.dto.Receiver;
import junit.framework.TestCase;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReceiversDaoTest extends TestCase {

    ReceiversDao receiversDao;

    @org.junit.Before
    public void setUp() throws Exception {
        receiversDao = new ReceiversDao(true);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void testInstance() {
        assertNotNull(receiversDao);
    }

    @Test
    public void testGetReceiver() throws ParseException, SQLException {
        //Given
        Receiver receiver = new Receiver();
        receiver.setName("Atlant-M");
        receiver.setId(1);

        //When
        receiversDao.addReceiver(receiver);

        //Then
        assertNotNull(receiver);
        assertEquals("Atlant-M", receiver.getName());
        assertEquals(receiver.toString(), receiversDao.getReceiver(1).toString());

        receiversDao.deleteAll();
    }

    @Test
    public void testAddReceiver() throws SQLException, ParseException {
        //Given
        Receiver receiver = new Receiver();
        receiver.setName("Atlant-M");

        //When
        receiversDao.addReceiver(receiver);

        //Then
        assertNotNull(receiver);
        assertEquals("Atlant-M", receiver.getName());

        receiversDao.deleteAll();
    }

    @Test
    public void testGetReceivers() throws SQLException {
        //Given
        List<Receiver> receiverList = receiversDao.getReceivers();
        //When
        assertNotNull(receiverList);
        //Than
        assertEquals(0,receiverList.size());
    }
}