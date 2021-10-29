package by.academy.it.data;

import by.academy.it.dto.Expense;
import by.academy.it.dto.Receiver;
import by.academy.it.input.ExpenseInput;
import by.academy.it.input.ReceiverInput;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    static public void getConsoleMenu() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        ExpensesDao expensesDao = new ExpensesDao();
        ReceiversDao receiversDao = new ReceiversDao();
        SubQuery subQuery = new SubQuery();

        int ch = 0;
        int innerCh;

        while (ch != 11) {
            System.out.println("Main Menu for Student Data Entry");
            System.out.println("1. Show table Expenses");
            System.out.println("2. Show table Receivers");
            System.out.println("3. Show table Expenses with receivers names");
            System.out.println("4. Add payment");
            System.out.println("5. Add receiver");
            System.out.println("6. Show list of recievers with payments sum");
            System.out.println("7. Get sum of payments of the day when was the highest payment");
            System.out.println("8. Get the highest payment of the day," +
                    " when the sum of payments was the highest payment");
            System.out.println("9. Get expence by id");
            System.out.println("10. Get receiver by id");

            System.out.println("11. Exit");

            System.out.print("Enter your choice : ");
            ch = sc.nextInt();

            if (ch == 1) {
                expensesDao.getAllExpenses();
                System.out.println("\n1.Exit");
                System.out.print("Enter to exit : ");
                ch = sc.nextInt();
            } else if (ch == 2) {
                receiversDao.getAllReceivers();
                System.out.println("\n1.Exit");
                System.out.print("Enter to exit : ");
                ch = sc.nextInt();
            } else if (ch == 3) {
                subQuery.getTableExpenseWithReceiverName();
                System.out.println("\n1.Exit");
                System.out.print("Enter to exit : ");
                ch = sc.nextInt();
            } else if (ch == 4) {
                innerCh = 0;
                while (innerCh != 2) {
                    ExpenseInput expenseInput = new ExpenseInput();
                    Expense expense = new Expense();
                    expenseInput.enterExpense();
                    expense.setDate(expenseInput.getDate());
                    expense.setReciever(expenseInput.getReceiver());
                    expense.setValue(expenseInput.getValue());
                    expensesDao.addExpence(expense);
                    System.out.println("\n1.Continue");
                    System.out.println("2.Exit to menu");
                    System.out.print("Enter your choice : ");
                    innerCh = sc.nextInt();
                }
            } else if (ch == 5) {
                innerCh = 0;
                while (innerCh != 2) {
                    ReceiverInput receiverInput = new ReceiverInput();
                    receiverInput.enterReceiver();
                    Receiver receiver = new Receiver();
                    receiver.setName(receiverInput.getNameReceiver());
                    receiversDao.addReceiver(receiver);
                    System.out.println("\n1.Continue");
                    System.out.println("2.Exit to menu");
                    System.out.print("Enter your choice : ");
                    innerCh = sc.nextInt();
                }
            } else if (ch == 6) {
                subQuery.getReceiversWithSum();
                System.out.println("\n1.Exit");
                System.out.print("Enter to exit : ");
                System.out.print("Enter your choice : ");
                ch = sc.nextInt();
            } else if (ch == 7) {
                subQuery.getDaySumValuesWhenMaxVal();
                System.out.println("\n1.Exit");
                System.out.print("Enter to exit : ");
                System.out.print("Enter your choice : ");
                ch = sc.nextInt();
            } else if (ch == 8) {
                subQuery.getMaxValueWhenMaxDaySum();
                System.out.println("\n1.Exit");
                System.out.print("\nEnter to exit : ");
                System.out.print("Enter your choice : ");
                ch = sc.nextInt();
            } else if (ch == 9) {
                innerCh = 0;
                while (innerCh != 2) {
                    System.out.print("Enter the id of payment: ");
                    int id = sc.nextInt();
                    while (id >= expensesDao.getExpenses().size() + 1) {
                        System.out.println("Id is out of range");
                        System.out.print("Please enter Id again: ");
                        id = sc.nextInt();
                    }
                    System.out.println(expensesDao.getExpense(id).toString());
                    System.out.println("\n1.Continue");
                    System.out.println("2.Exit to menu");
                    System.out.print("Enter your choice : ");
                    innerCh = sc.nextInt();
                }
            } else if (ch == 10) {
                innerCh = 0;
                while (innerCh != 2) {
                    System.out.print("Enter the id of receiver: ");
                    int id = sc.nextInt();
                    while (id >= receiversDao.getReceivers().size() + 1) {
                        System.out.println("Id is out of range");
                        System.out.print("Please enter Id again: ");
                        id = sc.nextInt();
                    }
                    System.out.println(receiversDao.getReceiver(id).toString());
                    System.out.println("\n1.Continue");
                    System.out.print("2.Exit to menu");
                    System.out.print("Enter your choice : ");
                    innerCh = sc.nextInt();
                }
            } else if (ch == 11) {
                System.exit(0);
            }
        }
    }
}
