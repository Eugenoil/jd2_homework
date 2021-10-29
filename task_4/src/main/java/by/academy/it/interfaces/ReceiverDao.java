package by.academy.it.interfaces;

import by.academy.it.dto.Receiver;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReceiverDao {
        Receiver getReceiver(int num);
        ArrayList<Receiver> getReceivers() throws SQLException;
        int addReceiver(Receiver receiver);

}
