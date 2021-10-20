package videojuego;

public abstract class Arma {

	private int damage = (int)(Math.random() * 20) + 10;
	private double critico;

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

	@Override
	public String toString() {
		return " [damage=" + damage + ", critico=" + critico + "])";
	}	
}
