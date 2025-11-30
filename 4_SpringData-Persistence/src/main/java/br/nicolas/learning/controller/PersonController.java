package br.nicolas.learning.controller;

import br.nicolas.learning.dto.PersonPostDTO;
import br.nicolas.learning.dto.PersonPutDTO;
import br.nicolas.learning.dto.PersonResponseDTO;
import br.nicolas.learning.entity.Person;
import br.nicolas.learning.mapper.PersonMapper;
import br.nicolas.learning.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path = "/people")
public class PersonController {

    @Autowired
    private PersonService service;

    @Autowired
    private PersonMapper mapper;

    @PostMapping (path = "/create")
    public ResponseEntity<PersonResponseDTO> create (@Valid @RequestBody PersonPostDTO dto) {
        Person createdPerson = service.create(mapper.parseToEntity(dto));

        return ResponseEntity.ok(mapper.parseToResponse(createdPerson));
    }

    @GetMapping (path = "/find-id/{id}")
    public ResponseEntity<PersonResponseDTO> findById (@PathVariable Long id) {
        Person foundPerson = service.findById(id);

        PersonResponseDTO response = mapper.parseToResponse(foundPerson);

        return ResponseEntity.ok(response);
    }

    @PutMapping (path = "/update")
    public ResponseEntity<PersonResponseDTO> update (@Valid @RequestBody PersonPutDTO dto) {
        Person updatedPerson = service.update(mapper.parseToEntity(dto));

        return ResponseEntity.ok(mapper.parseToResponse(updatedPerson));
    }

    @DeleteMapping (path = "/delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
