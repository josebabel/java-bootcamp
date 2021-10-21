package base.model.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Ram {
	
	@Value("#{utils.generateRandomNumber(50,150)}")
	private double precio;
	
	@Value("8")
	private int gb;
	private double hz;
	private String generacion;
	
	public Ram() {
		// TODO Auto-generated constructor stub
	}
	
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
