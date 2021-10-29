package by.academy.it.data;

import java.sql.*;

public class SubQuery {

    DataSource dataSource;

    public SubQuery() throws ClassNotFoundException {
        try {
            dataSource = new DataSource(false);
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cfne) {
            cfne.printStackTrace();
        }
    }

    public void getReceiversWithSum() {
        Connection connection;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String query = "select name, sum(value) as sum_payments \n" +
                    "from list_expenses.receivers r, list_expenses.expenses e \n" +
                    "where e.receiver = r.id group by name";
            statement.executeQuery(query);
            resultSet = statement.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            System.out.printf("%s - %s \n", rsmd.getColumnName(1), rsmd.getColumnName(2));
            while (resultSet.next()) {
                System.out.printf
                        ("%s - %f \n",
                                resultSet.getString(1),
                                resultSet.getDouble(2));
            }
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getDaySumValuesWhenMaxVal() {
        Connection connection;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String query = "select paydate, t1.sum_day \n" +
                    "from (select paydate, sum(value) as sum_day, max(value) as max_val \n" +
                    "from list_expenses.expenses group by paydate) t1\n" +
                    "order by max_val desc limit 1;";
            statement.executeQuery(query);
            resultSet = statement.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            System.out.printf("%s - %s \n", rsmd.getColumnName(1), rsmd.getColumnName(2));
            while (resultSet.next()) {
                System.out.printf
                        ("%s - %f \n",
                                resultSet.getString(1),
                                resultSet.getDouble(2));
            }
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getMaxValueWhenMaxDaySum() {
        Connection connection;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String query = "select paydate, t1.max_val \n" +
                    "from (select paydate, sum(value) as sum_day, max(value) as max_val \n" +
                    "from list_expenses.expenses group by paydate) t1\n" +
                    "order by sum_day desc limit 1;";
            statement.executeQuery(query);
            resultSet = statement.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            System.out.printf("%s - %s \n", rsmd.getColumnName(1), rsmd.getColumnName(2));
            while (resultSet.next()) {
                System.out.printf
                        ("%s - %f \n",
                                resultSet.getString(1),
                                resultSet.getDouble(2));
            }
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getTableExpenseWithReceiverName() {
        Connection connection;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String query = "select paydate, value, name \n" +
                    "from list_expenses.expenses e, list_expenses.receivers r\n" +
                    "where r.id = e.receiver";
            statement.executeQuery(query);
            resultSet = statement.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            System.out.printf("%s - %s - %s \n",
                    rsmd.getColumnName(1),
                    rsmd.getColumnName(2),
                    rsmd.getColumnName(3));
            while (resultSet.next()) {
                System.out.printf
                        ("%s - %f - %s \n",
                                resultSet.getString(1),
                                resultSet.getDouble(2),
                                resultSet.getString(3));
            }
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
