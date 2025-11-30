package br.nicolas.learning.mapper;

import br.nicolas.learning.dto.PersonPutDTO;
import br.nicolas.learning.dto.PersonResponse;
import br.nicolas.learning.entity.Person;
import org.mapstruct.*;

import java.time.LocalDate;
import java.time.Period;

@Mapper (componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PersonMapper {

    void updatePersonFromDto (PersonPutDTO dto, @MappingTarget Person person);

    @Mapping(source = "birthDate", target = "age", qualifiedByName = "birthToAge")
    PersonResponse parseToResponseDto (Person person);

    @Named("birthToAge")
    static int convertBirthDateToAge (LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
