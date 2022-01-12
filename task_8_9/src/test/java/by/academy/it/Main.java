package by.academy.it;

import by.academy.it.pojos.PersonNetworkProfile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.academy.it")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        PersonNetworkProfile profile = context.getBean("personNetworkProfile", PersonNetworkProfile.class);

        System.out.println(profile);
    }
}
