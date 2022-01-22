package by.academy.it.pojos;

import by.academy.it.interfaces.Company;
import by.academy.it.interfaces.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee implements Person {
    @Value("Vasya")
    private String name;

    @Value("Petrov")
    private String surname;

    @Autowired
    @Qualifier("itCompany")
    private Company company;

    @Autowired
    private EmailService service;

    public Employee(String name, String surname, Company company, EmailService service) {
        this.name = name;
        this.surname = surname;
        this.company = company;
        this.service = service;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Company getCompany() {
        return company;
    }

    public EmailService getService() {
        return service;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", company=" + company +
                ", email =" + service.getPersonEmail() +
                '}';
    }
}
