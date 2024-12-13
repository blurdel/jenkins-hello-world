package com.blurdel.hello.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.blurdel.hello.model.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// http://localhost:8080/hello
// http://localhost:8080/hello?name=Zoey

@RestController
@RequestMapping({"/", "/hello"})
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    public HelloController() {
        log.info("HelloController::");
    }


    @GetMapping()
    public Greeting getHello(@RequestParam(value = "name", defaultValue = "World!") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("health")
    public ResponseEntity<?> getHealth() {
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}
