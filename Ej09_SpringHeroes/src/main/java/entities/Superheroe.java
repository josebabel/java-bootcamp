package entities;

public class Superheroe {

	private static int id = 0;
	private int idCounter;
	private String nombre;
	private String nombreSuperheroe;
	private int poder;
	private String superpoder;
	
	public Superheroe() {
		id++;
		idCounter = id;
	}
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getNombreSuperheroe() {
		return nombreSuperheroe;
	}
	public int getPoder() {
		return poder;
	}
	public String getSuperpoder() {
		return superpoder;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNombreSuperheroe(String nombreSuperheroe) {
		this.nombreSuperheroe = nombreSuperheroe;
	}
	public void setPoder(int poder) {
		this.poder = poder;
	}
	public void setSuperpoder(String superpoder) {
		this.superpoder = superpoder;
	}
	@Override
	public String toString() {
		return "Superheroe [id=" + idCounter + ", nombre=" + nombre + ", nombreSuperheroe=" + nombreSuperheroe + ", poder="
				+ poder + ", superpoder=" + superpoder + "]";
	}
	
	
}
