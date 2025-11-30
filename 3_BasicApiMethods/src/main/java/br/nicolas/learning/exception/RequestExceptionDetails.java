package br.nicolas.learning.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RequestExceptionDetails {

    private int status;
    private String title;
    private String message;
    private String timestamp;
}
