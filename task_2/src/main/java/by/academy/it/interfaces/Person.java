package by.academy.it.interfaces;

public class Person {
    private Integer id;
    private Integer age;
    private String name;
    private String surname;
    private IAddress address;

    public Person(Integer id, Integer age, String name, String surname, IAddress address) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public IAddress getAddress() {
        return address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(IAddress address) {
        this.address = address;
    }

    public void init() {
        System.out.println("Initialization of Person");
    }

    public void destroy() {
        System.out.println("Destroy of Person");
    }

    public static Person getInstance() {
        return new Person();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                '}';
    }
}
