package base.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import base.model.controller.OrdenadorController;
import base.model.entity.Ordenador;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Ordenador o1 = context.getBean("ordenador", Ordenador.class);
		o1.setPrecio(o1.calcularPrecioComponentes());
		System.out.println(o1);
		
		OrdenadorController ordenadorController = context.getBean("ordenadorController", OrdenadorController.class);
		boolean res = ordenadorController.createFile(o1);
		System.out.println(res);

	}

}
