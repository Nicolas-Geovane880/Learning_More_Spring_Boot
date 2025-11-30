package br.nicolas.learning.service;

import br.nicolas.learning.entity.Person;
import br.nicolas.learning.exception.EmailAlreadyExistsException;
import br.nicolas.learning.exception.InvalidIdException;
import br.nicolas.learning.exception.ResourceNotFoundException;
import br.nicolas.learning.exception.handler.GlobalExceptionHandler;
import br.nicolas.learning.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public Person findById (Long id) {
        log.info("Finding a person with id '{}'...", id);

        if (id == null || id <= 0) throw new InvalidIdException("Id can't be lower or equals than 0.");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person with id '%d' not found.".formatted(id)));
    }

    public Person create (Person person) {
        log.info("Creating a person...");

        if (checkIfEmailAlreadyInUse(person.getEmail())) throw new EmailAlreadyExistsException("Email is already in use.");

        return repository.save(person);
    }

    public Person update (Person dto) {
        log.info("Updating a person with id '{}'...", dto.getId());

        Person foundUser = findById(dto.getId());

        if (dto.getEmail() != null && !dto.getEmail().equals(foundUser.getEmail())) {
            if (checkIfEmailAlreadyInUse(dto.getEmail())) {
                throw new EmailAlreadyExistsException("Email is already in use.");
            }
        }

        if (dto.getFirstName() != null) foundUser.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null) foundUser.setLastName(dto.getLastName());
        if (dto.getEmail() != null) foundUser.setEmail(dto.getEmail());
        if (dto.getBirthDate() != null) foundUser.setBirthDate(dto.getBirthDate());

        return repository.save(foundUser);
    }

    public void deleteById (Long id) {
        log.info("Deleting a person with id '{}'...", id);

        if (id == null || id <= 0) throw new InvalidIdException("Id can't be lower or equals than 0.");

        findById(id);

        repository.deleteById(id);
    }

    private boolean checkIfEmailAlreadyInUse (String email) {
        Optional<Person> toCheck = repository.findAll().stream()
                .filter(p -> p.getEmail().equals(email))
                .findFirst();

        return toCheck.isPresent();
    }
}
