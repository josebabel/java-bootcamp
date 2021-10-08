package ordenador;

import java.util.List;

public class Ordenador {

	private double precio;
	private String marca;
	private List<Ram> listaRam;
	private Procesador procesador;
	private List<Grafica> listGraficas;
	private List<Periferico> listPerifericos;
	private PlacaBase placa;
	
	public Ordenador(double precio, String marca, List<Ram> listaRam, Procesador procesador, List<Grafica> listGraficas,
			List<Periferico> listPerifericos, PlacaBase placa) {
		this.precio = precio;
		this.marca = marca;
		this.listaRam = listaRam;
		this.procesador = procesador;
		this.listGraficas = listGraficas;
		this.listPerifericos = listPerifericos;
		this.placa = placa;
	}
	
	

	public PlacaBase getPlaca() {
		return placa;
	}

	public double getPrecio() {
		return precio;
	}

	public String getMarca() {
		return marca;
	}

	public List<Ram> getListaRam() {
		return listaRam;
	}

	public Procesador getProcesador() {
		return procesador;
	}

	public List<Grafica> getListGraficas() {
		return listGraficas;
	}

	public List<Periferico> getListPerifericos() {
		return listPerifericos;
	}
	
	public void setPlaca(PlacaBase placa) {
		this.placa = placa;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setListaRam(List<Ram> listaRam) {
		this.listaRam = listaRam;
	}

	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}

	public void setListGraficas(List<Grafica> listGraficas) {
		this.listGraficas = listGraficas;
	}

	public void setListPerifericos(List<Periferico> listPerifericos) {
		this.listPerifericos = listPerifericos;
	}

	@Override
	public String toString() {
		return "Ordenador [precio=" + precio + ", marca=" + marca + ", listaRam=" + listaRam + ", procesador="
				+ procesador + ", listGraficas=" + listGraficas + ", listPerifericos=" + listPerifericos + "]";
	}
	
	public double calcularPrecioComponentes() {
		
		double total = 0;
		
		total += this.getPlaca().getPrecio();
		System.out.println("Placa Base: " + total);
		
		total += this.getProcesador().getPrecio();
		System.out.println("Procesador: " + total);
		
		for (Grafica grafica : this.getListGraficas()) {
			total += grafica.getPrecio();
			System.out.println("Grafica: " + total);
		}
		
		for (Ram ram : this.getListaRam()) {
			total += ram.getPrecio();
			System.out.println("RAM: " + total);
		}
		
		for (Periferico periferico: this.getListPerifericos()) {
			total += periferico.getPrecio();
			System.out.println("Periferico: " + total);
		}
		
		return total;
	}
	
}
