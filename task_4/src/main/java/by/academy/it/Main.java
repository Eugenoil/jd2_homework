package by.academy.it;

import by.academy.it.data.ExpensesDao;
import by.academy.it.data.Menu;
import by.academy.it.data.ReceiversDao;
import by.academy.it.data.SubQuery;
import by.academy.it.dto.Expense;
import by.academy.it.dto.Receiver;
import by.academy.it.input.ExpenseInput;
import by.academy.it.input.ReceiverInput;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Menu.getConsoleMenu();
    }
}
