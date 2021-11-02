package es.curso;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.curso.model.entity.Coche;
import es.curso.model.service.CocheService;

@SpringBootApplication
public class Ej21CocheCapasJpaDataSpringBootApplication implements CommandLineRunner{

	public static Scanner sc = new Scanner(System.in);
	
	@Autowired
	public static CocheService cocheService;
	
	@Autowired
	public Coche c;
	
	public static void main(String[] args) {
		SpringApplication.run(Ej21CocheCapasJpaDataSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String opcion = "";
		
		do {
			System.out.println("*************"+
                    "1. Crear coche\n" +
                    "2. Eliminar coche\n" +
                    "3. Modificar coche\n" +
                    "4. Listar uno\n" +
                    "5. Listar todos\n" +
                    "6. Salir\n");
			System.out.println("Escribe opcion: ");
			opcion = sc.nextLine();
			switch (opcion) {
			case "1":
				alta(c);
				break;
 
			case "2":
				eliminar();
				break;
				
			case "3":
				modificar(c);
				break;
				
			case "4":
				listarUno();
				break;
				
			case "5":
				listarTodos();
				break;
				
			case "6":
				System.out.println("EXIT");
				break;
				
			default:
				System.out.println("Opcion no valida");
				break;
			}
			
		} while (!opcion.equals("6"));
		
	}
	
	public static void alta(Coche c) {
		
		System.out.println("Introduce marca: ");
		c.setMarca(sc.nextLine());
		
		System.out.println("Introduce modelo: ");
		c.setModelo(sc.nextLine());
		
		System.out.println("Introduce kilometros: ");
		c.setKilometros(sc.nextInt());
		
		System.out.println("Introduce matricula: ");
		c.setMatricula(sc.nextLine());
		
		boolean res = cocheService.alta(c);
		if(res) {
			System.out.println("Se ha dado de alta el coche");
		} else {
			System.out.println("No se ha podido dar de alta el coche");
		}
		
	}
	
	public static void modificar(Coche c) {
		
		System.out.println("Introduce id: ");
		c.setId(sc.nextInt());
		
		System.out.println("Introduce marca: ");
		c.setMarca(sc.nextLine());
		
		System.out.println("Introduce modelo: ");
		c.setModelo(sc.nextLine());
		
		System.out.println("Introduce kilometros: ");
		c.setKilometros(sc.nextInt());
		
		System.out.println("Introduce matricula: ");
		c.setMatricula(sc.nextLine());
		
		boolean res = cocheService.modificar(c);
		if(res) {
			System.out.println("Se ha modificado el coche");
		} else {
			System.out.println("No se ha podido modificar el coche");
		}
	}
	
	public void eliminar() {
		
		System.out.println("Introduce id: ");
		int id = sc.nextInt();
		
		boolean res = cocheService.baja(id);
		if(res) {
			System.out.println("Se ha eliminado el coche");
		} else {
			System.out.println("No se ha eliminado el coche");
		}
	}
	
	public void listarUno() {
		System.out.println("Introduce id: ");
		int id = sc.nextInt();
		
		Coche c = cocheService.getOne(id);
		if(c != null) {
			System.out.println(c);
		} else {
			System.out.println("No se ha encontrado el coche");
		}
	}
	
	public void listarTodos() {
		List<Coche> listCoches = cocheService.getAll();
		for (Coche coche : listCoches) {
			System.out.println(coche);
		}
	}

}
