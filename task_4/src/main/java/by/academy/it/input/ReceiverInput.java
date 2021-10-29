package by.academy.it.input;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class ReceiverInput {
    private String nameReceiver;

    public void enterReceiver() {
        try {
            Scanner scanner = new Scanner(System.in);

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter receiver name: ");
            nameReceiver = sc.nextLine();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }
}
