package br.nicolas.learning.service;

import br.nicolas.learning.entity.Person;
import br.nicolas.learning.repository.PersonRepository;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    @Mock
    private PersonRepository repository;

    private PersonService service;

    public void shouldSaveUser () {
        Person person = Person.builder().firstName("Nicolas").build();

    }

}