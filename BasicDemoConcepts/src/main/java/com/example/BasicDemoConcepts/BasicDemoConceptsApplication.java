package com.example.BasicDemoConcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BasicDemoConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicDemoConceptsApplication.class, args);

//		ConfigurableApplicationContext applicationContext = SpringApplication.run(BasicDemoConceptsApplication.class,
//				args);
//		SpringComponent component = applicationContext.getBean(SpringComponent.class);
//		System.out.println(component.getMessage());
		System.out.println("Hello World...!");
	}

}
