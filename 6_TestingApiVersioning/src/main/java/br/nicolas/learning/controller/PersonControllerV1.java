package br.nicolas.learning.controller;

import br.nicolas.learning.dto.ApiResponse;
import br.nicolas.learning.dto.PersonPostDTOv1;
import br.nicolas.learning.dto.PersonResponseDTOv1;
import br.nicolas.learning.entity.Person;
import br.nicolas.learning.mapper.PersonMapper;
import br.nicolas.learning.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping (path = "/v1/people")
public class PersonControllerV1 {

    private PersonService service;

    private PersonMapper mapper;

    @PostMapping (path = "/create")
    public ResponseEntity<ApiResponse<PersonResponseDTOv1>> createPerson (@RequestBody PersonPostDTOv1 dto) {
        Person createdPerson = service.createPerson(mapper.parseToEntity(dto));

        ApiResponse<PersonResponseDTOv1> apiResponse = new ApiResponse<>();
        apiResponse.setData(mapper.parseToResponseV1(createdPerson));
        apiResponse.addWarning("DEPRECATED_FIELD - The field 'name' will be removed at 2026/03, please use 'firstName' and 'lastName'");

        return ResponseEntity.ok()
                .body(apiResponse);
//        return ResponseEntity.ok()
//                .header("Warning", "The 'name' field will be removed at the v3, please use 'firstName' and 'lastName'")
//                .body(mapper.parseToResponse(createdPerson));
    }


    @GetMapping (path = "/find-id/{id}")
    public ResponseEntity<ApiResponse<PersonResponseDTOv1>> findById (@PathVariable Long id) {
        Person foundPerson = service.findById(id);

        ApiResponse<PersonResponseDTOv1> apiResponse = new ApiResponse<>();
        apiResponse.setData(mapper.parseToResponseV1(foundPerson));
        apiResponse.addWarning("DEPRECATED_FIELD - The field 'name' will be removed at 2026/03, please use 'firstName' and 'lastName'");

        return ResponseEntity.ok()
                .body(apiResponse);
    }
}
