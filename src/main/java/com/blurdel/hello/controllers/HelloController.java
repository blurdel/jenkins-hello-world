package com.blurdel.hello.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.blurdel.hello.model.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// http://localhost:8080/hello
// http://localhost:8080/hello?name=Zoey

@Slf4j
@RestController
@RequestMapping({"/", "/hello"})
public class HelloController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    public HelloController() {
        log.info("HelloController::");
    }


    @GetMapping()
    public Greeting getHello(@RequestParam(value = "name", defaultValue = "World!") String name) {
        log.debug("/hello {}", String.format(template, name));
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
