package entities;

public class Rezo extends Arma {

	public Rezo() { 
		super.setCritico(1.75);
	}

	@Override
	public String toString() {
		return "Rezo" + super.toString();
	}
	
}