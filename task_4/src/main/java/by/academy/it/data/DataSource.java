package by.academy.it.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    boolean useTestDataSource;

    public DataSource(boolean useTestDataSource) {
        this.useTestDataSource = useTestDataSource;
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                useTestDataSource ?
                        "jdbc:mysql://localhost:3306/list_expenses_test":
                        "jdbc:mysql://localhost:3306/list_expenses",
                "root",
                "root");
    }
}
