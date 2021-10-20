package entities;

public class Hechizo extends Arma {

	public Hechizo() { 
		super.setCritico(2);
	}

	@Override
	public String toString() {
		return "Hechizo" + super.toString();
	}
	
}