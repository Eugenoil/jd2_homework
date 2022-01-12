package by.academy.it;

import by.academy.it.interfaces.IAddress;
import by.academy.it.pojo.Address;
import by.academy.it.interfaces.Person;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


class AppTest {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");

        IAddress address = (Address) applicationContext.getBean("address");

        Person person = (Person) applicationContext.getBean("person");

        System.out.println(person);
        System.out.println(address);

        applicationContext.close();
    }
}