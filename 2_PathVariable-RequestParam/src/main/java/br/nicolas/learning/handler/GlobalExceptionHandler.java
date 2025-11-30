package br.nicolas.learning.handler;

import br.nicolas.learning.exception.InvalidNumberException;
import br.nicolas.learning.exception.InvalidOperationOptionException;
import br.nicolas.learning.exception.RequestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler (InvalidNumberException.class)
    public ResponseEntity<RequestExceptionDetails> invalidNumberExceptionHandler (InvalidNumberException e) {
        RequestExceptionDetails details = RequestExceptionDetails.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("An error occurs with the values format.")
                .message(e.getMessage())
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")))
                .build();
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (InvalidOperationOptionException.class)
    public ResponseEntity<RequestExceptionDetails> invalidOperationOptionExceptionHandler (InvalidOperationOptionException e) {
        RequestExceptionDetails details = RequestExceptionDetails.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("An error occurs with the operation option.")
                .message(e.getMessage())
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")))
                .build();
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
}
