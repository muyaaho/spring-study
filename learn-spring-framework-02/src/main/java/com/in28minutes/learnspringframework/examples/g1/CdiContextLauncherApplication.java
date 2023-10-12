package com.in28minutes.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

// CDI annotation이 Spring Annotation을 대체한다는 점을 알아보는 코드

//@Component
@Named
class BusinessService {
	private DataService dataService;

	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		// 세터 주입이 수행되어, 데이터 서비스에 주입할 수 있게 됐어요??
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}
	
	public DataService getDataService() {
		return dataService;
	}

}

//@Component
@Named
class DataService {
	
}

@Configuration 
@ComponentScan
public class CdiContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext
				(CdiContextLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessService.class).getDataService());
			
		}
		
	}

}
