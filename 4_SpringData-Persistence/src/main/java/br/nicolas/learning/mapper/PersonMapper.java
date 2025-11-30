package br.nicolas.learning.mapper;

import br.nicolas.learning.dto.PersonPostDTO;
import br.nicolas.learning.dto.PersonPutDTO;
import br.nicolas.learning.dto.PersonResponseDTO;
import br.nicolas.learning.entity.Person;
import org.mapstruct.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Mapper (componentModel = "spring",
         nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PersonMapper {

    Person parseToEntity (PersonPostDTO dto);

    Person parseToEntity (PersonPutDTO dto);

    List<PersonResponseDTO> parseToResponseList (List<Person> people);

    @Mapping (source = "person", target = "fullName", qualifiedByName = "mergeName")
    @Mapping (source = "birthDate", target = "age", qualifiedByName = "convertBirthDate")
    PersonResponseDTO parseToResponse (Person person);

    @Named (value = "mergeName")
    static String mergeFirstAndLastName (Person person) {
        return person.getFirstName() + " " + person.getLastName();
    }

    @Named (value = "convertBirthDate")
    static int convertBirthDateToAge (LocalDate date) {
        return Period.between(date, LocalDate.now()).getYears();
    }
}
