package br.nicolas.learning.mapper;

import br.nicolas.learning.dto.PersonPostDTOv1;
import br.nicolas.learning.dto.PersonPostDTOv2;
import br.nicolas.learning.dto.PersonResponseDTOv1;
import br.nicolas.learning.dto.PersonResponseDTOv2;
import br.nicolas.learning.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.Period;

@Mapper (componentModel = "spring")
public interface PersonMapper {

    // ------------------- v1 _ Will be removed soon ----------------------
    @Mapping(source = "birthDay", target = "age", qualifiedByName = "convertToAge")
    PersonResponseDTOv1 parseToResponseV1(Person entity);

    Person parseToEntity(PersonPostDTOv1 dto);

    // ------------------- v2 _ Current version ---------------------------

    @Mapping(source = "birthDay", target = "age", qualifiedByName = "convertToAge")
    PersonResponseDTOv2 parseToResponseV2 (Person entity);

    Person parseToEntity (PersonPostDTOv2 dto);

    @Named("convertToAge")
    static int convertBirthDayToAge (LocalDate birthDay) {
        return Period.between(birthDay, LocalDate.now()).getYears();
    }


}
