package br.nicolas.learning.dto;

import br.nicolas.learning.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;

@Builder
@JsonPropertyOrder ({"first_name", "email", "last_name", "age", "gender"})
public record PersonResponseDTOv2
        (
         @JsonProperty (value = "first_name")
         String firstName,

         @JsonProperty (value = "last_name")
         String lastName,

         String email,

         int age,

         @JsonSerialize (using = GenderSerializer.class)
         String gender) {
}