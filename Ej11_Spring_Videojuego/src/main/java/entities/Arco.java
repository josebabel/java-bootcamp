package entities;

public class Arco extends Arma {

	public Arco() { 
		super.setCritico(1.5);
	}
	
	@Override
	public String toString() {
		return "Arco" + super.toString();
	}
	
}