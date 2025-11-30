package br.nicolas.learning.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record PersonPutDTO
        (@NotNull(message = "The ID can not be null or blank")
         Long id,
         String firstName,
         String lastName,
         String email,
         LocalDate birthDate) {}