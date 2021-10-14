package entidades;

public class Barco extends Vehiculo {
	
	public Barco(int hp, String nombre) {
		super(hp, nombre);
	}
	
	@Override
	public void mover(int metros) {
		int distancia = metros + getHp() * 2;
		System.out.println(this + " se ha movido " + distancia + "m");
	}

}
