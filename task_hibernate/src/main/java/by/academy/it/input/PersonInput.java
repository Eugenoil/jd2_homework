package by.academy.it.input;

import by.academy.it.pojos.Person;

import java.util.Scanner;

public class PersonInput {

    static public void enterPersonInfo(Person person) {
        Scanner scanner = new Scanner(System.in);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter person name: ");
        person.setName(sc.nextLine());

        System.out.print("Enter person surname: ");
        person.setSurname(sc.nextLine());

        System.out.print("Enter person age: ");
        person.setAge(sc.nextInt());
    }
}
