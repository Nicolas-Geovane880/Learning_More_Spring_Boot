package br.nicolas.learning.exception.handler;

import br.nicolas.learning.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler (ResourceNotFoundException.class)
    public ResponseEntity<RequestExceptionDetails> handleResourceNotFoundException (ResourceNotFoundException e, WebRequest request) {

        String path = request.getDescription(false).replace("uri=", "");

        String method = ((ServletWebRequest) request ).getRequest().getMethod();

        RequestExceptionDetails details = RequestExceptionDetails.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found.")
                .message(e.getMessage())
                .method(method)
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (NoResourceFoundException.class)
    public ResponseEntity<RequestExceptionDetails> handleNoResourceFoundException (NoResourceFoundException e, WebRequest request) {
        String path = request.getDescription(false).replace("uri=", "");

        String method = ((ServletWebRequest) request ).getRequest().getMethod();

        RequestExceptionDetails details = RequestExceptionDetails.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Path not found.")
                .message(e.getMessage())
                .method(method)
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (InvalidIdException.class)
    public ResponseEntity<RequestExceptionDetails> handleInvalidIdException (InvalidIdException e, WebRequest request) {
        log.warn("An error occurred while trying to process the ID: {}", e.getMessage());

        String path = request.getDescription(false).replace("uri=", "");

        String method = ((ServletWebRequest) request ).getRequest().getMethod();

        RequestExceptionDetails details = RequestExceptionDetails.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Id is invalid.")
                .message(e.getMessage())
                .method(method)
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<InvalidObjectFieldDetails> handleMethodArgumentNotValidException (MethodArgumentNotValidException e, WebRequest request) {

        String path = request.getDescription(false).replace("uri=", "");

        String method = ((ServletWebRequest) request ).getRequest().getMethod();

        String fields = e.getFieldErrors().stream()
                .map(f -> f.getField() + "(" + f.getDefaultMessage() + ")")
                .collect(Collectors.joining(", "));

        log.warn("An error occurred while processing the object: '%s'".formatted(fields));

        InvalidObjectFieldDetails details = InvalidObjectFieldDetails.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Invalid fields.")
                .message("Can not process because some field(s) may be null or outside the excepted pattern.")
                .method(method)
                .path(path)
                .timestamp(LocalDateTime.now())
                .invalidFields(fields)
                .build();

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (EmailAlreadyExistsException.class)
    public ResponseEntity<RequestExceptionDetails> handleEmailAlreadyExistsException (EmailAlreadyExistsException e, WebRequest request) {
        
        String path = request.getDescription(false).replace("uri=", "");

        String method = ((ServletWebRequest) request ).getRequest().getMethod();

        RequestExceptionDetails details = RequestExceptionDetails.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Invalid email.")
                .message(e.getMessage())
                .method(method)
                .path(path)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (Exception.class)
    public ResponseEntity<ExceptionDetails> handleGenericException (Exception e, WebRequest request) {
        String path = request.getDescription(false).replace("uri=", "");

        String method = ((ServletWebRequest) request ).getRequest().getMethod();

        ExceptionDetails details = ExceptionDetails.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("An unexpected error occurred.")
                .message(e.getMessage())
                .method(method)
                .path(path)
                .build();

        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }


}


