package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		
		// 1: Launch a Spring Context
		try(var context = new AnnotationConfigApplicationContext
				(HelloWorldConfiguration.class)){
			// 2: Configure the things that we want Spring to manage - 
			// HelloWorldConfiguration - @Configuration
			// name - @Bean
			
			// 3: Retrieving Beans managed by Spring
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person3Parameters"));
			System.out.println(context.getBean("address2"));
			
			System.out.println();
			System.out.println(context.getBean(Person.class));
			System.out.println(context.getBean(Address.class));
			/*
			 * 에러 생기는 이유: Address.class는 spring bean을 불러오는데(getBean) address인 bean?이
			 * address2, address3 둘 다 있어 어떤 bean을 가져올지 몰라서 생기는 에러
			 * 해결 1: @Primary - 하나를 기본으로 만들기
			 * 해결 2: @Qualifier("이름") - 한정자 지정해주기
			 */
			
			System.out.println();
			System.out.println(context.getBean("person5Qualifier"));
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		}
			
	}

}
