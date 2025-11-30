package br.nicolas.learning.dto;

import lombok.Builder;

@Builder
public record PersonResponseDTOv1
        (String name,
         String email,
         int age) {
}