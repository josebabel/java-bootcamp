package ordenador;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		//ORDENADOR
		Ordenador pc = new Ordenador(0, null, null, null, null, null, null);
		
		//RAM
		List<Ram> listRam = new ArrayList<Ram>();
		Ram r1 = new Ram(50, 8, 3200, "DDR4");
		Ram r2 = new Ram(50, 8, 3200, "DDR4");
		listRam.add(r1);
		listRam.add(r2);
		
		//PROCESADOR
		Procesador pro1 = new Procesador(300, 3600, "AMD Ryzen 5 3700x", null);
		
		//GRAFICA
		List<Grafica> listGraficas = new ArrayList<Grafica>();
		Grafica g1 = new Grafica(450, 1770, "NVIDIA", "RTX 2070 SUPER", null);
		Ram rg1 = new Ram(0, 8, 1770, "GDDR6");
		g1.setRam(rg1);
		listGraficas.add(g1);
		
		//PLACA BASE
		PlacaBase pla1 = new PlacaBase(170, "ASUS", "ROG Strix X570");
		
		//PERIFERICOS
		List<Periferico> listPerifericos = new ArrayList<Periferico>();
		Periferico per1 = new Periferico(TipoPeriferico.MONITOR, 200);
		Periferico per2 = new Periferico(TipoPeriferico.TECLADO, 40);
		Periferico per3 = new Periferico(TipoPeriferico.RATON, 15);
		Periferico per4 = new Periferico(TipoPeriferico.CASCOS, 60);
		listPerifericos.add(per1);
		listPerifericos.add(per2);
		listPerifericos.add(per3);
		listPerifericos.add(per4);
		
		
		pc.setListaRam(listRam);
		pc.setProcesador(pro1);
		pc.setListGraficas(listGraficas);
		pc.setListPerifericos(listPerifericos);
		pc.setPlaca(pla1);
		
		System.out.println(pc.toString());
		System.out.println(pc.calcularPrecioComponentes() + "€");
		
		
	
	}

}
