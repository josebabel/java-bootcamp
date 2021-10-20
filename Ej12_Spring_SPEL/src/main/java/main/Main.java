package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Grafica;
import entities.Marcas;
import entities.Ordenador;
import entities.TipoPeriferico;
import model.DaoOrdenador;
import utils.Utils;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Ordenador o1 = context.getBean("ordenador", Ordenador.class);
		o1.setPrecio(o1.calcularPrecioComponentes());
		System.out.println(o1);
		
		boolean res = DaoOrdenador.createFile(o1);
		if(res) {
			System.out.println("Se ha creado el fichero correctamente");
		} else {
			System.out.println("No se ha podido crear el fichero");
		}
	}

}
