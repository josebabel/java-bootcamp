package ordenador;

public class Procesador {

	private double precio;
	private double hz;
	private String marca;
	private Grafica grafica;
	
	public Procesador(double precio, double hz, String marca, Grafica grafica) {
		this.precio = precio;
		this.hz = hz;
		this.marca = marca;
		this.grafica = grafica;
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

	public Grafica getGrafica() {
		return grafica;
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

	public void setGrafica(Grafica grafica) {
		this.grafica = grafica;
	}

	@Override
	public String toString() {
		return "Procesador [precio=" + precio + ", hz=" + hz + ", marca=" + marca + ", grafica=" + grafica + "]";
	}
	
	
}
