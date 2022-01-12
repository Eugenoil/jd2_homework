package by.academy.it.pojos;

import by.academy.it.interfaces.Vehicle;
import by.academy.it.interfaces.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PersonImpl implements Person {
    @Value("12sqw")
    private String id;

    @Value("Eugene")
    private String name;

    @Value("Dunin")
    private String surname;

    @Autowired
    @Qualifier("car")
    private Vehicle dailyVehilce;

    @Autowired
    @Qualifier("bike")
    private Vehicle dayoffVehicle;

    public PersonImpl(String id, String name, String surname, Vehicle dailyVehilce, Vehicle dayoffVehicle) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dailyVehilce = dailyVehilce;
        this.dayoffVehicle = dayoffVehicle;
    }

    public PersonImpl() {
    }

    @Override
    public String toString() {
        return "PersonImpl{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dailyVehilce=" + dailyVehilce +
                ", dayoffVehicle=" + dayoffVehicle +
                '}';
    }
}
