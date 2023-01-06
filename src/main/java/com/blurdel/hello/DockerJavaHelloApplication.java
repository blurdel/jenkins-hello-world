package com.blurdel.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerJavaHelloApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DockerJavaHelloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(new Greeting().getGreeting());
	}

}
