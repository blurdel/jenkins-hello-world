package com.blurdel.hello.model;

public class Greeting {

	private final long count;
	private final String greeting;


	public Greeting(final long count, final String greeting) {
		this.count = count;
		this.greeting = greeting;
	}

	public long getCount() {
		return count;
	}

	public String getGreeting() {
		return greeting;
	}

//	public String getGreeting(String name) {
//		return "Hello " + name;
//	}
	
}
