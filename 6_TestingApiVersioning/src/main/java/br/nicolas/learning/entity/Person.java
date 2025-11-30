package br.nicolas.learning.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Person")
public class Person {

    /*

    In a scenario where the Person object has name as field, but later we decided to use first and last name rather name.
    It probably 'd break the client-side because they are expecting an object with name as field (a dto in the case),
    but we are sending an object with the first and last name as fields inside a response.

    Therefore, this change doesn't modify our business rule, but the API contract.

    */

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "name", nullable = false)
    private String name; // <- This field is legacy, will be removed soon

    @Column (name = "email", nullable = false, unique = true)
    private String email;

    @Column (name = "first_name") //
    private String firstName;     //
                                  // new fields
    @Column (name = "last_name")  //
    private String lastName;      //

    @Column (name = "birth_day")
    private LocalDate birthDay;

    @Column (name = "gender")
    private String gender; // new field too
}
