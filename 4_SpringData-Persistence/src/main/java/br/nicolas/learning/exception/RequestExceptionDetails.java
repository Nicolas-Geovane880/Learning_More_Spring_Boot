package br.nicolas.learning.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class RequestExceptionDetails extends ExceptionDetails { //Exception class to detail requests errors
}
