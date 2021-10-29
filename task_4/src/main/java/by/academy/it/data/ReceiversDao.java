package by.academy.it.data;

import by.academy.it.dto.Receiver;
import by.academy.it.interfaces.ReceiverDao;

import java.sql.*;
import java.util.ArrayList;

public class ReceiversDao implements ReceiverDao {

    private DataSource dataSource;

    public ReceiversDao() throws ClassNotFoundException {
        this(false);
    }

    public ReceiversDao(boolean useTestDataSource) throws ClassNotFoundException {
        try {
            dataSource = new DataSource(useTestDataSource);
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cfne) {
            cfne.printStackTrace();
        }
    }

    public void getAllReceivers() throws SQLException{
        ArrayList<Receiver> receivers = getReceivers();
        for (int i = 0; i < receivers.size(); i++) {
            Receiver receiver = receivers.get(i);
            System.out.println(receiver.toString());
        }
    }

    @Override
    public Receiver getReceiver(int id) {
        Connection connection;
        ResultSet resultSet = null;
        Receiver receiver = null;
        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String query = "select * from receivers r where r.id =" + id + ";";
            statement.executeQuery(query);
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                receiver = new Receiver();
                receiver.setId(id);
                receiver.setName(resultSet.getString("name"));
            }
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receiver;
    }

    @Override
    public ArrayList<Receiver> getReceivers() throws SQLException {
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM receivers");
        ArrayList<Receiver> receiverList = new ArrayList<>();
        while (rs.next()) {
            Receiver receiver = new Receiver();
            receiver.setId(rs.getInt("id"));
            receiver.setName(rs.getString("name"));
            receiverList.add(receiver);
        }
        st.close();
        con.close();
        return receiverList;
    }

    @Override
    public int addReceiver(Receiver receiver) {
        Connection connection;
        try {
            connection = dataSource.getConnection();
            String query = "insert into receivers (name) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, receiver.getName());
            preparedStatement.executeUpdate();
            getAllReceivers();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public  void  deleteAll() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("TRUNCATE TABLE receivers").execute();
        connection.close();
    }
}
