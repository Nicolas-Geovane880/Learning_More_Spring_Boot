package br.nicolas.learning.dto;

import java.time.LocalDate;

public record PersonPostDTOv1
        (String name,
         String email,
         LocalDate birthDay) {
}