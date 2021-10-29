package by.academy.it.data;

import by.academy.it.dto.Expense;
import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ExpensesDaoTest extends TestCase {

    ExpensesDao expensesDao;

    @org.junit.Before
    public void setUp() throws Exception {
        expensesDao = new ExpensesDao(true);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void testInstance() {
        assertNotNull(expensesDao);
    }

    @Test
    public void testGetExpense() throws ParseException, SQLException {
        //Given
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String str = "12-12-2020";
        java.util.Date date = sdf.parse(str);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Expense newExpense = new Expense();
        newExpense.setId(1);
        newExpense.setDate(sqlDate);
        newExpense.setReciever(1);
        newExpense.setValue(2000.0);

        //When
        expensesDao.addExpence(newExpense);

        //Then
        assertNotNull(newExpense);
        assertEquals(newExpense.toString(), expensesDao.getExpense(1).toString());

        expensesDao.deleteAll();
    }

    @Test
    public void testGetExpenses() throws SQLException {
        //Given
        List<Expense> expenseList = expensesDao.getExpenses();
        //When
        assertNotNull(expenseList);
        //Than
        assertEquals(0,expenseList.size());
    }

    @Test
    public void testAddExpence() throws SQLException, ParseException {
        //Given
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String str = "12-12-2020";
        java.util.Date date = sdf.parse(str);
        java.sql.Date sqlDate= new java.sql.Date(date.getTime());
        Expense newExpense = new Expense();
        newExpense.setDate(sqlDate);
        newExpense.setReciever(1);
        newExpense.setValue(2000.0);

        //When
        expensesDao.addExpence(newExpense);

        //Then
        assertNotNull(newExpense);
        assertEquals(2000.0, newExpense.getValue());
        assertEquals(1, newExpense.getReciever());

        expensesDao.deleteAll();
    }
}