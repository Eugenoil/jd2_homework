package by.academy.it.pojos;

import by.academy.it.interfaces.Vehicle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {

    @Value("13")
    private String id;

    @Value("Ducati")
    private String brand;

    @Value("Panigale")
    private String model;

    @Value("Sportbike")
    private String type;

    public Bike(String id, String brand, String model, String type) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.type = type;
    }

    public Bike() {
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
