package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Ordenador;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Ordenador o1 = context.getBean("ordenador", Ordenador.class);
		System.out.println(o1);
		o1.calcularPrecioComponentes();

	}

}
