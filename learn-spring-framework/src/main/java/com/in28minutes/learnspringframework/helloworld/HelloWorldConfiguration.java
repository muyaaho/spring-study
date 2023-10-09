package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// record: JDK 16에서 새로 추가된 기능
// 게터, 세터 생성자 등을 만들지 않아도 됨 
record Person (String name, int age, Address address) { };
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
		return new Person("Heeji", 20, new Address("Main Street", "Cheongok"));
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address());	 // name, age
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address3) {	// name, age, address2
		return new Person(name, age, address3);	 // 매개변수 호출
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address3) {	// name, age, address2
		return new Person(name, age, address3);	 // 매개변수 호출
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {	// name, age, address2
		return new Person(name, age, address);	 // 매개변수 호출
	}
	
	@Bean(name = "address2")
	@Primary
	public Address address() {
		return new Address("Baker Street", "London");
	}
	
	@Bean(name = "address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		return new Address("Udu-dong", "Chuncheon");
	}
}
