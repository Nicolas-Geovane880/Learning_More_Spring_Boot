package br.nicolas.learning.controller;

import br.nicolas.learning.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/math")
public class CalculatorController {

    @Autowired
    private CalculatorService service;

    @RequestMapping (method = RequestMethod.GET, path = "/operation/{mathOperation}/{numberOne}/{numberTwo}")
    public Double mathOperation (@PathVariable (value = "mathOperation") String mathOperation,
                                 @PathVariable (value = "numberOne") String numberOne,
                                 @PathVariable (value = "numberTwo") String numberTwo) {

        return service.mathOperation(numberOne, numberTwo, mathOperation);
    }
}
