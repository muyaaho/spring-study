package com.in28minutes.learnspringframework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass {
	
}

@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{
	
}

@Configuration 
@ComponentScan
public class BeanScopesLauncherApplication {
	
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext
				(BeanScopesLauncherApplication.class)){
			
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
//			동일한 bean 검색(해시 코드가 같음): 싱글톤
//			com.in28minutes.learnspringframework.examples.e1.NormalClass@3514a4c0
//			com.in28minutes.learnspringframework.examples.e1.NormalClass@3514a4c0
			
			
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
//			호출할 때마다 새로운 해시 코드가 나옴: 프로토타입
//			com.in28minutes.learnspringframework.examples.e1.PrototypeClass@212b5695
//			com.in28minutes.learnspringframework.examples.e1.PrototypeClass@446293d
//			com.in28minutes.learnspringframework.examples.e1.PrototypeClass@69997e9d
			
		}
		
	}

}
