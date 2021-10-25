package base.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import base.cfg.ConfiguracionJPA;
import base.utils.MenuOptions;

public class Main {
	
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(ConfiguracionJPA.class);
		
		Scanner sc = new Scanner(System.in);
		String option;
		
		do {
			System.out.println("\n***** MENU COCHES JPA *****\n"
					+ "1. Crear coche\n"
					+ "2. Modificar coche\n"
					+ "3. Borrar coche\n"
					+ "4. Listar un coche\n"
					+ "5. Listar todos los coches\n"
					+ "6. Salir");
			System.out.println("Escribe opcion: ");
			option = sc.nextLine();
			switch (option) {
			case "1":
				MenuOptions.crearCoche(context);
				break;
				
			case "2":
				MenuOptions.modificarCoche(context);
				break;
				
			case "3":
				MenuOptions.eliminarCoche(context);
				break;
				
			case "4":
				MenuOptions.listarUnCoche(context);
				break;
				
			case "5":
				MenuOptions.listarTodos(context);
				break;
				
			case "6":
				System.out.println("EXIT");
				break;
				
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (!option.equals("6"));
	}

}
