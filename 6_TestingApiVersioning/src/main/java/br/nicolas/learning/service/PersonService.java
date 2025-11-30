package br.nicolas.learning.service;

import br.nicolas.learning.entity.Person;
import br.nicolas.learning.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository repository;

    public Person createPerson (Person person) {
        if (person.getName() == null || person.getName().isBlank()) {
            String first = person.getFirstName();
            String last  = person.getLastName();

            if (first != null && last != null) {
                person.setName(first + " " + last);
            }

            if (first != null && last == null) {
                person.setName(first);
            }

            if (first == null && last == null) {
                throw new IllegalArgumentException("If you're using the v1, please inform a name. If you're using the v2, please inform either first and last name");
            }
        }
        return repository.save(person);
    }

    public Person findById(Long id) {
        Person foundPerson = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Person with id '%d' not found".formatted(id)));

        if (foundPerson.getFirstName() == null && foundPerson.getLastName() == null) {
            String[] nameParts = foundPerson.getName().split(" ");

            String firstName = nameParts[0];
            String lastName = nameParts[nameParts.length - 1];

            foundPerson.setFirstName(firstName);
            foundPerson.setLastName(lastName);
        }

        return foundPerson;
    }
}
