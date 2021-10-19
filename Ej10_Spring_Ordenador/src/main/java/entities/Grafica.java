package entities;

public class Grafica {

	private double precio;
	private double hz;
	private String marca;
	private String modelo;
	private Ram ram;
	
	public Grafica() {
		// TODO Auto-generated constructor stub
	}
	
	public Grafica(double precio, double hz, String marca, String modelo, Ram ram) {
		super();
		this.precio = precio;
		this.hz = hz;
		this.marca = marca;
		this.modelo = modelo;
		this.ram = ram;
	}

	public double getPrecio() {
		return precio;
	}

	public double getHz() {
		return hz;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Ram getRam() {
		return ram;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setHz(double hz) {
		this.hz = hz;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Grafica [precio=" + precio + ", hz=" + hz + ", marca=" + marca + ", modelo=" + modelo + ", ram=" + ram
				+ "]";
	}
	
	
	
	
}
