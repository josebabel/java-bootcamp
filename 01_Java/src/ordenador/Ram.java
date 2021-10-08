package ordenador;

public class Ram {
	
	private double precio;
	private int gb;
	private double hz;
	private String generacion;
	
	public Ram(double precio, int gb, double hz, String generacion) {
		this.precio = precio;
		this.gb = gb;
		this.hz = hz;
		this.generacion = generacion;
	}

	public double getPrecio() {
		return precio;
	}
	
	public int getGb() {
		return gb;
	}

	public double getHz() {
		return hz;
	}

	public String getGeneracion() {
		return generacion;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public void setGb(int gb) {
		this.gb = gb;
	}

	public void setHz(double hz) {
		this.hz = hz;
	}

	public void setGeneracion(String generacion) {
		this.generacion = generacion;
	}

	@Override
	public String toString() {
		return "Ram [precio=" + precio + ", gb=" + gb + ", hz=" + hz + ", generacion=" + generacion + "]";
	}


	
	
}
