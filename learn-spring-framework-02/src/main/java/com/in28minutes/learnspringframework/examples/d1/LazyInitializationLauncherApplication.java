package com.in28minutes.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
	
}

@Component
@Lazy	// 자동으로 초기화가 일어나지 않음 -> classB를 사용할 때만 초기화 일어남
class ClassB {
	
	private ClassA classA;
	public ClassB (ClassA classA) {
		System.out.println("Some Initialization logic");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do Something");
	}
}


@Configuration 
@ComponentScan
public class LazyInitializationLauncherApplication {
	
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext
				(LazyInitializationLauncherApplication.class)){
			
			// classB를 부르지 않아도 자동으로 classB를 부름! (@Lazy가 없을 때)
//			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println("Initialization of context is completed");
			context.getBean(ClassB.class).doSomething();
			
			
		}
		
	}

}
