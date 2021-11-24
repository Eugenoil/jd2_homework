package by.academy.it.pojos;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String model;

    @Column
    private int power;

    public Car() {
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }
}
