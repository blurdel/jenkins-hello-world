package com.blurdel.hello;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.blurdel.hello.model.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DockerJavaHelloApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Test
	void testGreeting() {
		assertEquals("Hello", new Greeting(1, "Hello").getGreeting(), "Greeting method should return 'Hello World'");
	}

	@Test
	void TestAll() {
		assertAll(
				() -> assertEquals("Hello World", new Greeting(1, "Hello World").getGreeting()),
				() -> assertEquals("Hello Fred", new Greeting(2, "Hello Fred").getGreeting())
				);
	}
	
}
