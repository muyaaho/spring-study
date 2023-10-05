package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// record: JDK 16에서 새로 추가된 기능
// 게터, 세터 생성자 등을 만들지 않아도 됨 
record Person (String name, int age) { };
record Address(String firstline, String city) { };

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Jihee";
	}
	
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		return new Person("Heeji", 20);
	}
	
	@Bean
	public Address address() {
		return new Address("Baker Street", "London");
	}
}
