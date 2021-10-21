package base.model.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "placaBase")
@Scope(value = "singleton")
public class PlacaBase {

	@Value("#{utils.generateRandomNumber(100, 300)}")
	private double precio;
	
	@Value("#{utils.randomBrand()}")
	private String marca;
	
	@Value("X570")
	private String modelo;
	
	public PlacaBase() {
		// TODO Auto-generated constructor stub
	}
	
	public PlacaBase(double precio, String marca, String modelo) {
		this.precio = precio;
		this.marca = marca;
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "PlacaBase [precio=" + precio + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	
	
	
}
