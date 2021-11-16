package by.academy.it.ui;

import by.academy.it.data.PersonDao;
import by.academy.it.input.PersonInput;
import by.academy.it.pojos.Person;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    static public void getConsoleMenu() {
        Scanner sc = new Scanner(System.in);
        PersonDao personDao = new PersonDao();

        int ch = 0;
        int innerCh;

        while (ch != 11) {
            System.out.println("Main Menu for list_persons database");
            System.out.println("1. Add new person");
            System.out.println("2. Delete person by ID");
            System.out.println("3. Find person by ID with GET - method");
            System.out.println("4. Find person by ID with LOAD - method");
            System.out.println("5. Synchronize object with database state");
            System.out.println("6. Exit");

            System.out.print("Enter your choice : ");
            ch = sc.nextInt();

            if (ch == 1) {
                innerCh = 0;
                while (innerCh != 2) {
                    Person person = new Person();
                    PersonInput.enterPersonInfo(person);
                    if (personDao.saveAndDelete(person)) {
                        System.out.println("Person saved successfully");
                        System.out.println(person);
                    } else {
                        System.out.println("Save error");
                    }
                    System.out.println("\n1.Continue");
                    System.out.println("2.Exit to menu");
                    System.out.print("Enter your choice : ");
                    innerCh = sc.nextInt();
                }
            } else if (ch == 2) {
                System.out.println("Please enter ID of what you want to delete : ");
                int id = sc.nextInt();
                if (personDao.saveAndDelete(id)) {
                    System.out.println("Entry was deleted successfully");
                } else {
                    System.out.println("Error occured");
                }
                System.out.println("\n1.Exit");
                System.out.print("Enter to exit : ");
                ch = sc.nextInt();
            } else if (ch == 3) {
                innerCh = 0;
                while (innerCh != 2) {
                    System.out.println("Please enter ID what you want to find with method GET : ");
                    int id = sc.nextInt();
                    System.out.println(personDao.findPersonWithGet(id));
                    System.out.println("\n1.Continue");
                    System.out.println("2.Exit to menu");
                    System.out.print("Enter to exit : ");
                    innerCh = sc.nextInt();
                }
            } else if (ch == 4) {
                innerCh = 0;
                while (innerCh != 2) {
                    System.out.println("Please enter ID what you want to find with method LOAD : ");
                    int id = sc.nextInt();
                    System.out.println(personDao.findPersonWithLoad(id));
                    System.out.println("\n1.Continue");
                    System.out.println("2.Exit to menu");
                    System.out.print("Enter to exit : ");
                    innerCh = sc.nextInt();
                }
            } else if (ch == 5) {
                innerCh = 0;
                while (innerCh != 2) {
                    System.out.println("Please enter ID what you want to synchronize : ");
                    int id = sc.nextInt();
                    Person person = personDao.findPersonWithGet(id);
                    if (person != null) {
                        personDao.synchronizeWithDatabase(person);
                        System.out.println(person);
                        System.out.println("Object synchronized successful");
                    } else {
                        System.out.println("Impossible to find such an object in database");
                    }
                    System.out.println("\n1.Continue");
                    System.out.println("2.Exit to menu");
                    System.out.print("Enter to exit : ");
                    innerCh = sc.nextInt();
                }
            } else if (ch == 6) {
                System.exit(0);
            }
        }
    }
}
