package br.nicolas.learning.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;

@SuperBuilder
@Getter
@AllArgsConstructor
public class ExceptionDetails { //Generic Exception Details class

    protected int status;

    protected String title;

    protected String message;

    protected LocalDateTime timestamp;

    protected String method;

    protected String path;
}
