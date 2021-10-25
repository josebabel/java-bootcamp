package base.utils;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import base.persistence.controller.CocheController;
import base.persistence.entity.Coche;

public class MenuOptions {
	
	private static Scanner sc = new Scanner(System.in);

	public static void crearCoche(ApplicationContext context) {
		CocheController cocheController = context.getBean("cocheController", CocheController.class);
		
		System.out.println("Marca: ");
		String marca = sc.nextLine();
		
		System.out.println("Modelo: ");
		String modelo = sc.nextLine();
		
		System.out.println("Matricula: ");
		String matricula = sc.nextLine();
		
		System.out.println("Kilometros: ");
		int kilometros = sc.nextInt();
		
		Coche c = context.getBean("coche", Coche.class);
		c.setMarca(marca);
		c.setModelo(modelo);
		c.setKilometros(kilometros);
		c.setMatricula(matricula);
		int id = cocheController.create(c);
		System.out.println("Coche insertado ID " + id);
	}
	
	public static void modificarCoche(ApplicationContext context) {
		CocheController cocheController = context.getBean("cocheController", CocheController.class);
		
		System.out.println("ID: ");
		int id = sc.nextInt();
		
		System.out.println("Marca: ");
		String marca = sc.nextLine();
		
		System.out.println("Modelo: ");
		String modelo = sc.nextLine();
		
		System.out.println("Matricula: ");
		String matricula = sc.nextLine();
		
		System.out.println("Kilometros: ");
		int kilometros = sc.nextInt();
		
		Coche c = context.getBean("coche", Coche.class);
		c.setMarca(marca);
		c.setModelo(modelo);
		c.setKilometros(kilometros);
		c.setMatricula(matricula);
		Coche modificado = cocheController.update(c);
		System.out.println("Coche modificado: " + modificado);
	}
	
	public static void eliminarCoche(ApplicationContext context) {
		CocheController cocheController = context.getBean("cocheController", CocheController.class);
		
		System.out.println("ID: ");
		int id = sc.nextInt();
		
		int IDborrado = cocheController.delete(id);
		System.out.println("Coche eliminado: " + IDborrado);
	}
	
	public static void listarUnCoche(ApplicationContext context) {
		CocheController cocheController = context.getBean("cocheController", CocheController.class);
		
		System.out.println("ID: ");
		int id = sc.nextInt();
		
		Coche c = cocheController.getOne(id);
		System.out.println(c);
	}
	
	public static void listarTodos(ApplicationContext context) {
		CocheController cocheController = context.getBean("cocheController", CocheController.class);
		
		List<Coche> listCoches = cocheController.getAll();
		listCoches.forEach((v) -> System.out.println(v));
	}
}
