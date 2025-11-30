package br.nicolas.learning.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private Long id;

    private String firstName;

    private String LastName;

    private String address;

    private String genre;
}
