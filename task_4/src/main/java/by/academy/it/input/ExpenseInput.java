package by.academy.it.input;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ExpenseInput {
    private java.sql.Date date;
    private int receiver;
    private double value;

    public void enterExpense() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            Scanner sc = new Scanner(System.in).useLocale(Locale.US);
            System.out.print("Enter date in format of MM-dd-yyyy: ");
            String str = sc.nextLine();
            DateValidatorDateFormat dateFormat = new DateValidatorDateFormat("MM-dd-yyyy");
            while (!dateFormat.isValid(str)) {
                System.out.println("DateTime format is invalid. Please enter again correctly" +
                        "with 'MM-dd-yyyy' date format");
                str = sc.nextLine();
            }
            Date date = sdf.parse(str);
            this.date = new java.sql.Date(date.getTime());
            System.out.print("Input number of reciever: ");
            this.receiver = sc.nextInt();

            System.out.print("Input value of payment: ");
            this.value = sc.nextDouble();
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
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
