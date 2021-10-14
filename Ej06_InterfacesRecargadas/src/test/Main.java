package test;

import java.util.ArrayList;
import java.util.List;

import entidades.*;

public class Main {

	public static void main(String[] args) {
		
		Moto m1 = new Moto(200, "Kawasaki");
		Coche c1 = new Coche(100, "Seat Ibiza");
		Barco b1 = new Barco(500, "Lancha");
		Avion a1 = new Avion(2000, "Airbus A380");
				
		List<Vehiculo> listado = new ArrayList<Vehiculo>();
		listado.add(m1);
		listado.add(c1);
		listado.add(b1);
		listado.add(a1);
		
		for(Vehiculo v : listado) {
			v.mover(500);
		}

	}

}
