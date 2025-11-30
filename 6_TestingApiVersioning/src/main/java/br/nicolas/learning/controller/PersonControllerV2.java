package br.nicolas.learning.controller;

import br.nicolas.learning.dto.ApiResponse;
import br.nicolas.learning.dto.PersonPostDTOv2;
import br.nicolas.learning.dto.PersonResponseDTOv2;
import br.nicolas.learning.entity.Person;
import br.nicolas.learning.mapper.PersonMapper;
import br.nicolas.learning.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping (path = "/v2/people")
public class PersonControllerV2 {

    private PersonService service;

    private PersonMapper mapper;

    @GetMapping (path = "/find-id/{id}")
    public ResponseEntity<ApiResponse<PersonResponseDTOv2>> findById (@PathVariable Long id) {
        Person foundPerson = service.findById(id);

        ApiResponse<PersonResponseDTOv2> apiResponse = new ApiResponse<>();
        apiResponse.setData(mapper.parseToResponseV2(foundPerson));

        return ResponseEntity.ok()
                .body(apiResponse);
    }

    @PostMapping (path = "/create")
    public ResponseEntity<ApiResponse<PersonResponseDTOv2>> createPerson (@RequestBody PersonPostDTOv2 dto) {
        Person createdPerson = service.createPerson(mapper.parseToEntity(dto));

        ApiResponse<PersonResponseDTOv2> apiResponse = new ApiResponse<>();
        apiResponse.setData(mapper.parseToResponseV2(createdPerson));

        return ResponseEntity.ok()
                .body(apiResponse);
    }

}
