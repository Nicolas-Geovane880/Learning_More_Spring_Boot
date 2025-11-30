package br.nicolas.learning.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
@Entity
@Table (name = "Person")
public class Person {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name", nullable = false, length = 60)
    private String name;

    @Column (name = "email", nullable = false, unique = true, length = 60)
    private String email;

    @Column (name = "birth_date", nullable = false)
    private LocalDate birthDate;
}
