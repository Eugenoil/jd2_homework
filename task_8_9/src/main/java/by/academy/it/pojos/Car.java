package by.academy.it.pojos;

import by.academy.it.interfaces.Vehicle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

    @Value("1")
    private String id;

    @Value("BMW")
    private String brand;

    @Value("M3")
    private String model;

    public Car(String id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
