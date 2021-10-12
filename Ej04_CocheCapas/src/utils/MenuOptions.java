package utils;

import java.util.List;
import java.util.Scanner;

import controlador.CocheController;
import entidad.Coche;

public class MenuOptions {

	public static void crear(CocheController cc, Scanner sc) {
		
		System.out.print("Matricula: ");
		String matricula = sc.next();
		
		System.out.print("Marca: ");
		String marca = sc.next();
		
		System.out.print("Modelo: ");
		String modelo = sc.next();
		
		System.out.print("Kilometros: ");
		int km = sc.nextInt();
		
		boolean res = cc.create(matricula, marca, modelo, km);
		
		if(res) {
			System.out.println("Se ha creado el registro");
		} else {
			System.out.println("Ha ocurrido un error al crear el registro");
		}
	}
	
	public static void borrar(CocheController cc, Scanner sc) {
		
		System.out.print("Matricula: ");
		String matricula = sc.next(); 
		
		boolean res = cc.delete(matricula);
		
		if(res) {
			System.out.println("Se ha eliminado el registro");
		} else {
			System.out.println("No existe ese registro");
		}
	}
	
	public static void modificar(CocheController cc, Scanner sc) {
		
		System.out.print("Matricula: ");
		String matricula = sc.next();
		
		System.out.print("Marca: ");
		String marca = sc.next();
		
		System.out.print("Modelo: ");
		String modelo = sc.next();
		
		System.out.print("Kilometros: ");
		int km = sc.nextInt();
		
		boolean res = cc.update(matricula, marca, modelo, km);
		
		if(res) {
			System.out.println("Se ha actualizado el registro");
		} else {
			System.out.println("Ha ocurrido un error al modificar el registro");
		}
	}
	
	public static void listarUno(CocheController cc, Scanner sc) {
		
		System.out.print("Matricula: ");
		String matricula = sc.next();
		
		Coche c = cc.getOne(matricula);
		
		if(c != null) {
			System.out.println(c.toString());
		} else {
			System.out.println("No existe ese registro");
		}
		
	}
	
	public static void listarTodos(CocheController cc) {
		List<Coche> listado = cc.getAll();
		
		if(listado != null) {
			for(Coche c: listado) {
				System.out.println(c.toString());
			}
		} else {
			System.out.println("No se pueden recuperar los registros");
		}
	}
	
}
