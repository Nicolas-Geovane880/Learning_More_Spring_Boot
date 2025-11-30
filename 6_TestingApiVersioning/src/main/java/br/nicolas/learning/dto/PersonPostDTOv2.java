package br.nicolas.learning.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PersonPostDTOv2
        (String firstName,
         String lastName,
         String email,
         LocalDate birthDay) {
}