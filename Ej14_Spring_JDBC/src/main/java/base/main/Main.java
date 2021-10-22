package base.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import base.cfg.JavaConfig;
import base.utils.MenuOptions;

public class Main {

	private static ApplicationContext context;
	
	public static void main(String[] args) {
		
		context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Scanner sc = new Scanner(System.in);
		String option;
		
		do {
			System.out.println("\n***** MENU CLIENTES/PEDIDOS *****\n"
					+ "1. Alta cliente | 2. Baja cliente\n"
					+ "3. Modificar cliente | 4. Buscar cliente por nombre\n"
					+ "5. Buscar cliente por ID | 6. Anadir pedido a cliente por id\n"
					+ "7. Listar pedidos de cliente por id | 8. Salir");
			System.out.println("Escribe opcion: ");
			option = sc.nextLine();
			switch (option) {
			case "1":
				MenuOptions.altaCliente(context, sc);
				break;
				
			case "2":
				MenuOptions.bajaCliente(context, sc);
				break;
				
			case "3":
				MenuOptions.modificarCliente(context, sc);
				break;
				
			case "4":
				MenuOptions.clienteByName(context, sc);
				break;
				
			case "5":
				MenuOptions.clienteById(context, sc);
				break;
				
			case "6":
				MenuOptions.addPedidoByClientId(context, sc);
				break;
				
			case "7":
				MenuOptions.getPedidosByClientId(context, sc);
				break;
				
			case "8":
				System.out.println("EXIT");
				break;
				
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (!option.equals("8"));
	
	}

}
