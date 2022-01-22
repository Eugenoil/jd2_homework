package by.academy.it.pojos;

import by.academy.it.interfaces.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PersonNetworkProfile {
    @Value("Eugenol")
    private String nickname;

    @Autowired
    private Person person;

    public PersonNetworkProfile(String nickname, Person person) {
        this.nickname = nickname;
        this.person = person;
    }

    public PersonNetworkProfile() {
    }


    @Override
    public String toString() {
        return "PersonNetworkProfile{" +
                "nickname='" + nickname + '\'' +
                ", person=" + person +
                '}';
    }
}
