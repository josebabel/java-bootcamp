package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import negocio.Batalla;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Batalla batalla = context.getBean("batalla", Batalla.class);
		batalla.empezar();
	}

}
