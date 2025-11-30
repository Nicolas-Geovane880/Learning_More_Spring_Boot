package br.nicolas.learning.service;

import br.nicolas.learning.exception.InvalidNumberException;
import br.nicolas.learning.exception.InvalidOperationOptionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Autowired
    private NumberConverter converter;

    public Double mathOperation (String strNumberOne, String strNumberTwo, String operation) {
        double doubleNumberOne = converter.convertStringToNumber(strNumberOne);
        double doubleNumberTwo = converter.convertStringToNumber(strNumberTwo);

        switch (operation.toLowerCase()) {
            case "sum" -> { return doubleNumberOne + doubleNumberTwo; }

            case "subtraction" -> { return doubleNumberOne - doubleNumberTwo; }

            case "multiplication" -> { return doubleNumberOne * doubleNumberTwo; }

            case "mean" -> { return (doubleNumberOne + doubleNumberTwo) / 2; }

            case "division" -> {
                if (doubleNumberTwo == 0) {
                    throw new InvalidNumberException("Can't divide by zero.");
                }
                return doubleNumberOne / doubleNumberTwo;
            }

            default -> throw new InvalidOperationOptionException("Operation '%s' is invalid.".formatted(operation));
        }
    }
}
