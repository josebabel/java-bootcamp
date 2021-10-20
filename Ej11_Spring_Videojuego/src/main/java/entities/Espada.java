package entities;

public class Espada extends Arma {

	public Espada() { 
		super.setCritico(2.5);
	}

	@Override
	public String toString() {
		return "Espada" + super.toString();
	}
	
}
