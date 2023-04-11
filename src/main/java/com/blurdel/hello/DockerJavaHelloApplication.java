package com.blurdel.hello;

import com.blurdel.hello.model.Greeting;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerJavaHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerJavaHelloApplication.class, args);
	}

}
