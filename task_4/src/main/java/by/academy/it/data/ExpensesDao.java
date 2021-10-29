package by.academy.it.data;

import by.academy.it.dto.Expense;
import by.academy.it.interfaces.ExpenseDao;

import java.sql.*;
import java.util.ArrayList;

public class ExpensesDao implements ExpenseDao {

    private DataSource dataSource;

    public ExpensesDao() throws ClassNotFoundException {
        this(false);
    }

    public ExpensesDao(boolean useTestDataSource) throws ClassNotFoundException {
        try {
            dataSource = new DataSource(useTestDataSource);
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cfne) {
            cfne.printStackTrace();
        }
    }

    public void getAllExpenses() throws SQLException {
        ArrayList<Expense> expenses = getExpenses();
        for (int i = 0; i < expenses.size(); i++) {
            Expense expense = expenses.get(i);
            System.out.println(expense.toString());
        }
    }


    @Override
    public Expense getExpense(int id) {
        Connection connection;
        ResultSet resultSet = null;
        Expense expense = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String query = "select * from expenses e where e.id =" + id + ";";
            statement.executeQuery(query);
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                expense = new Expense();
                expense.setId(id);
                expense.setDate(resultSet.getDate("paydate"));
                expense.setValue(resultSet.getDouble("value"));
                expense.setReciever(resultSet.getInt("receiver"));
            }
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expense;
    }

    @Override
    public ArrayList<Expense> getExpenses() throws SQLException {
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM expenses");
        ArrayList<Expense> expenseList = new ArrayList<>();
        while (rs.next()) {
            Expense expense = new Expense();
            expense.setId(rs.getInt("id"));
            expense.setDate(rs.getDate("paydate"));
            expense.setReciever(rs.getInt("receiver"));
            expense.setValue(rs.getDouble("value"));
            expenseList.add(expense);
        }
        st.close();
        con.close();
        return expenseList;
    }

    @Override
    public void addExpence(Expense expense) {
        Connection connection;
        try {
            connection = dataSource.getConnection();
            String query = "insert into expenses (paydate, receiver, value) values(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, expense.getDate());
            preparedStatement.setInt(2, expense.getReciever());
            preparedStatement.setDouble(3, expense.getValue());
            preparedStatement.executeUpdate();
            getAllExpenses();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  void  deleteAll() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("TRUNCATE TABLE expenses").execute();
        connection.close();
    }
}
