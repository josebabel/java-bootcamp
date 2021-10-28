package es.curso.modelo.entidad;

public class Videojuego {

	private int id;
	private String nombre;
	private String compania;
	private double nota;
	private String creador;
	private String enlace;
	private String foto;
	
	public Videojuego() {
		// TODO Auto-generated constructor stub
	}
	
	public Videojuego(int id, String nombre, String compania, double nota, String creador, String enlace, String foto) {
		this.id = id;
		this.nombre = nombre;
		this.compania = compania;
		this.nota = nota;
		this.creador = creador;
		this.enlace = enlace;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", compania=" + compania + ", nota=" + nota
				+ ", creador=" + creador + ", enlace=" + enlace + ", foto=" + foto + "]";
	}
	
	
	
	
	
	
}
