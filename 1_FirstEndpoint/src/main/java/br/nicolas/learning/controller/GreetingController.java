package br.nicolas.learning.controller;

import br.nicolas.learning.entity.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping ("greetings")
public class GreetingController {

    private static final String template = "Hello, %s";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping (method = RequestMethod.GET, path = "/greeting/{content}")
    public Greeting greeting (@PathVariable String content) {

        return new Greeting(counter.incrementAndGet(), String.format(template, content));
    }
}
