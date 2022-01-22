package by.academy.it.pojos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private Employee employee;

    public String getPersonEmail(){

        return employee.getName()  + "@gmail.com";
    }

}
