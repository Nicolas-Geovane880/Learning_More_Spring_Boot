package br.nicolas.learning.service;

import br.nicolas.learning.entity.Person;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Log4j2
public class PersonService {

    private static final AtomicLong counter = new AtomicLong();

    public Person findById (Long id) {
        log.info("Finding person with id '{}'.", id);

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Id can't be equals or lower than 0.");
        }
        return mockPerson();
    }

    public List<Person> findAll () {
        log.info("Finding all people.");

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Person mockPerson = mockPerson(i);
            people.add(mockPerson);
        }

        return people;
    }

    public Person create (Person person) {
        log.info("Creating a person.");

        person.setId(counter.incrementAndGet());

        return person;
    }

    public Person update (Person person) {
        log.info("Updating a person.");

        person.setId(counter.incrementAndGet());
        person.setFirstName("Updated first name");

        return person;
    }

    public void delete (Long id) {
        log.info("Deleting a person with id '{}'.", id);

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Id can't be equals or lower than 0.");
        }
    }

    private Person mockPerson () {
        return Person.builder()
                .id(counter.incrementAndGet())
                .firstName("Nicolas")
                .LastName("Geovane")
                .address("Brazil")
                .genre("Male")
                .build();
    }

    private Person mockPerson (int i) {
        return Person.builder()
                .id(counter.incrementAndGet())
                .firstName("First name " + i)
                .LastName("Last name " + i)
                .address("Place " + i)
                .genre("Prefer not tell")
                .build();
    }


}
