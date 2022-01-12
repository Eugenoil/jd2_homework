package by.academy.it.pojo;


import by.academy.it.interfaces.IAddress;

public class Address implements IAddress {
    private String id;
    private String street;
    private String home;


    public Address(String id, String street, String home) {
        this.id = id;
        this.street = street;
        this.home = home;
    }

    public Address() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void init() {
        System.out.println("Initialization of Address");
    }

    public void destroy() {
        System.out.println("Destroy of Address");
    }

    public static Address getAddress() {
        return new Address();
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", street='" + street + '\'' +
                ", home='" + home + '\'' +
                '}';
    }
}
