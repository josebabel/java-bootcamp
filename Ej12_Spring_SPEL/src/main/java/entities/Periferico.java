package entities;

public class Periferico {
	
	private TipoPeriferico tipo;
	private double precio;
	
	public Periferico() {
		// TODO Auto-generated constructor stub
	}
	
	public Periferico(TipoPeriferico tipo, double precio) {
		this.tipo = tipo;
		this.precio = precio;
	}

	public TipoPeriferico getTipo() {
		return tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setTipo(TipoPeriferico tipo) {
		this.tipo = tipo;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Periferico [tipo=" + tipo + ", precio=" + precio + "]";
	}
}
