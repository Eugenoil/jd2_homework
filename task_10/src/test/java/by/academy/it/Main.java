package by.academy.it;

import by.academy.it.interfaces.Person;
import by.academy.it.pojos.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = Component.class))
public class Main {
    public static void main(String[] args) {
        //ConfigurableApplicationContext applicationContext =
         //       new ClassPathXmlApplicationContext(App.class);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        Person person = context.getBean("employee", Employee.class);

        System.out.println(person);
    }
}
