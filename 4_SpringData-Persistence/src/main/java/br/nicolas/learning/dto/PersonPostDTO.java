package br.nicolas.learning.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record PersonPostDTO
        (@NotBlank(message = "The first name can not be null or blank")
         @Size(min = 5, max = 50, message = "The first name must be between 5 - 60 characters long")
         String firstName,

         @NotBlank(message = "The last name can not be null or blank")
         @Size(min = 5, max = 50, message = "The last name must be between 5 - 60 characters long")
         String lastName,

         @Email(message = "The email address must be valid")
         @NotBlank(message = "The email address can not be null or blank")
         @Size(min = 10, max = 40, message = "The email address must be between 10 - 40 characters long")
         String email,

         @NotNull(message = "The birth date can not be null")
         LocalDate birthDate) {}