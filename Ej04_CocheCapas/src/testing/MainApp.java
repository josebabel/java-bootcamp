package testing;

import java.util.Scanner;

import controlador.CocheController;
import utils.MenuOptions;

public class MainApp {

	public static void main(String[] args) {
		
		CocheController cc = new CocheController();
		Scanner sc = new Scanner(System.in);
		String option;
		
		do {
			System.out.println("\n*******************\nCRUD Coches\n 1 - Crear | 2 - Borrar\n 3 - Modificar | 4 - Listar uno\n 5 - Listar todos | 6 - Salir");
			System.out.print("Escribe opcion: ");
			option = sc.next();
			
			switch (option) {
			case "1":
				MenuOptions.crear(cc, sc);
				break;
				
			case "2":
				MenuOptions.borrar(cc, sc);
				break;
				
			case "3":
				MenuOptions.modificar(cc, sc);
				break;
				
			case "4":
				MenuOptions.listarUno(cc, sc);
				break;
				
			case "5":
				MenuOptions.listarTodos(cc);
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
