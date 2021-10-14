package entidades;

import interfaces.Movible;

public class Vehiculo implements Movible{

	private static int id = 0;
	private int idCode;
	private int hp;
	private String nombre;
	
	public Vehiculo(int hp, String nombre) {
		id++;
		idCode = id;
		this.hp = hp;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}
	
	public int getHp() {
		return hp;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + idCode + ", hp=" + hp + ", nombre=" + nombre + "]";
	}
	
}
