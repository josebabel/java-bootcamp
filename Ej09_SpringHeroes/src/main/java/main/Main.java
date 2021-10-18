package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Superheroe;

public class Main {

	public static ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		List<Superheroe> listPotencia = context.getBean("listadoPotencia", ArrayList.class);
		List<Superheroe> listVuelo = context.getBean("listadoVuelo", ArrayList.class);
		String option;

		do {

			System.out.println(
					"\n*******************\nMenu Heroes\n 1 - Listar los 3 supers\n 2 - Agregar super con potencia 100\n 3 - Agregar super con poder Vuelo\n 4 - Listar supers con potencia 100\n 5 - Listar supers con Vuelo\n 6 - Salir");
			System.out.print("Escribe opcion: ");
			option = sc.next();

			switch (option) {
			case "1":
				list3Supers();
				break;

			case "2":
				addSuperWithPower(listPotencia);
				break;

			case "3":
				addSuperWithVuelo(listVuelo);
				break;

			case "4":
				listPower(listPotencia);
				break;

			case "5":
				listVuelo(listVuelo);
				break;

			case "6":
				System.out.println("EXIT");
				break;

			default:
				System.out.println("Opcion no valida");
				break;
			}

		} while (!option.equals("6"));
		sc.close();
	}

	public static void list3Supers() {

		List<Superheroe> listSupers = context.getBean("listado3Supers", ArrayList.class);
		listSupers.add(context.getBean("batman", Superheroe.class));
		listSupers.add(context.getBean("superman", Superheroe.class));
		listSupers.add(context.getBean("green_lantern", Superheroe.class));

		for (Superheroe superheroe : listSupers) {
			System.out.println(superheroe);
		}
	}

	public static void addSuperWithPower(List<Superheroe> listPotencia) {

		Superheroe sh = context.getBean("superPrototype01", Superheroe.class);

		superData(sh);

		System.out.print("Superpoder: ");
		String superpoder = sc.next();
		
		sh.setSuperpoder(superpoder);

		listPotencia.add(sh);
	}

	public static void addSuperWithVuelo(List<Superheroe> listVuelo) {

		Superheroe sh = context.getBean("superPrototype02", Superheroe.class);

		superData(sh);

		System.out.print("Potencia: ");
		int potencia = sc.nextInt();
		
		sh.setPoder(potencia);

		listVuelo.add(sh);
	}
	
	public static void listPower(List<Superheroe> listPotencia) {
		for (Superheroe superheroe : listPotencia) {
			System.out.println(superheroe);
		}
	}
	
	public static void listVuelo(List<Superheroe> listVuelo) {
		for (Superheroe superheroe : listVuelo) {
			System.out.println(superheroe);
		}
	}

	public static void superData(Superheroe sh) {

		System.out.print("Nombre normal: ");
		String nombre = sc.next();
		
		System.out.print("Nombre super: ");
		String nombreSuper = sc.next();
		

		sh.setNombre(nombre);
		sh.setNombreSuperheroe(nombreSuper);
	}

}
