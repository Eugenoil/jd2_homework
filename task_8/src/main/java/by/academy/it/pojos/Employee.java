package by.academy.it.pojos;


import javax.persistence.*;

@Entity(name = "EMPLOYEE")
@DiscriminatorValue("E")
public class Employee extends Person {

    private static final long serialVersionUID = 4L;
    private String company;
    private Double salary;

    public Employee() {
    }

    public String getCompany() {
        return company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "company='" + company + '\'' +
                ", salary=" + salary + ", name=" + getName() +
                ", surname= " + getSurname() +
                '}';
    }
}
