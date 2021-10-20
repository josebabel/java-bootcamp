package entities;

public abstract class Arma {

	private int damage = (int)(Math.random() * 20) + 10;
	private double critico;
	private Personaje personaje;
	
	public Arma() {
		// TODO Auto-generated constructor stub
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public double getCritico() {
		return critico;
	}

	public void setCritico(double critico) {
		this.critico = critico;
	}
	
	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
	@Override
	public String toString() {
		return "[damage=" + damage + ", critico=" + critico + "]";
	}

	
}
