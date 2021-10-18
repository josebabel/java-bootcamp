package persistence.entity;

public class Coche {

	private int id;
	private String matricula;
	private String marca;
	private String modelo;
	private int kilometros;
	
	public int getId() {
		return id;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public int getKilometros() {
		return kilometros;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo
				+ ", kilometros=" + kilometros + "]";
	}
}
