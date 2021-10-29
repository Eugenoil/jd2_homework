package by.academy.it.interfaces;

import by.academy.it.dto.Expense;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExpenseDao {
    Expense getExpense(int num);

    ArrayList<Expense> getExpenses() throws SQLException;

    void addExpence(Expense expense);
}
