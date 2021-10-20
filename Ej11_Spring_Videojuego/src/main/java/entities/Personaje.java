package entities;

public abstract class Personaje {

	private String nombre;
	private int vida;
	private Arma arma;
	private int probabilidadCritico;
	
	public Personaje() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getVida() {
		return vida;
	}
	
	public Arma getArma() {
		return arma;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public int getProbabilidadCritico() {
		return probabilidadCritico;
	}

	public void setProbabilidadCritico(int probabilidadCritico) {
		this.probabilidadCritico = probabilidadCritico;
	}

	public abstract void ataca(Personaje p);

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", vida=" + vida + ", arma=" + arma + ", probabilidad de critico="
				+ probabilidadCritico + "]";
	}

	
	
}
