package br.nicolas.learning.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class InvalidObjectFieldDetails extends ExceptionDetails {

    private String invalidFields;
}
