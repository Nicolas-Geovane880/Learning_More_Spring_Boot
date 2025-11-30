package br.nicolas.learning.service;

import br.nicolas.learning.exception.InvalidNumberException;
import org.springframework.stereotype.Component;

@Component
public class NumberConverter {

    public double convertStringToNumber (String strNumber) {
        try {
            return Double.parseDouble(strNumber.replace(",", "."));
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("The input '%s' is invalid.".formatted(strNumber));
        }
    }
}
