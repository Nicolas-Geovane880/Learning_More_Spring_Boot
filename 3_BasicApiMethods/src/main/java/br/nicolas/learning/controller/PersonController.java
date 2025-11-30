package br.nicolas.learning.controller;

import br.nicolas.learning.entity.Person;
import br.nicolas.learning.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/people")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping (method = RequestMethod.GET, path = "/find-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person>  findById (@PathVariable (value = "id") Long id) {
        Person foundPerson = service.findById(id);

        return ResponseEntity.ok(foundPerson);
    }

    @RequestMapping (method = RequestMethod.GET, path = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> findAll () {
        List<Person> allFoundPeople = service.findAll();

        return ResponseEntity.ok(allFoundPeople);
    }

    @RequestMapping (method = RequestMethod.POST, path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE,
                                                                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> create (@RequestBody Person person) {
        Person createdPerson = service.create(person);

        return ResponseEntity.ok(createdPerson);
    }

    @RequestMapping (method = RequestMethod.PUT, path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
                                                                   produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> update (@RequestBody Person person) {
        Person updatedPerson = service.update(person);

        return ResponseEntity.ok(updatedPerson);
    }

    @RequestMapping (method = RequestMethod.DELETE, path = "/delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }





}
