package base.model.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class Procesador {

	@Value("#{utils.generateRandomNumber(100, 500)}")
	private double precio;
	
	@Value("1770")
	private double hz;
	
	@Value("#{utils.randomBrand()}")
	private String marca;
	private Grafica grafica;
	
	public Procesador() {
		// TODO Auto-generated constructor stub
	}
	
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
