package videojuego;

public class Guerrero extends Personaje {

	private int fuerza;
	
	public Guerrero(String nombre, int vida, Arma arma) {
		super.setNombre(nombre);
		super.setVida(vida);
		super.setArma(arma);
		super.setProbabilidadCritico(15);
		this.fuerza = 10;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	@Override
	public String toString() {
		return super.toString() + " Guerrero [fuerza=" + fuerza + "]";
	}
	
	public void ataca(Personaje p) {
		int damage = this.getArma().getDamage();
		int criticoRandom = (int)(Math.random() * 100); 
		
		if(this.getArma() instanceof Espada || this.getArma() instanceof Arco) {
			damage += this.getFuerza();
		}
		
		if(criticoRandom <= this.getProbabilidadCritico()) {
			System.out.println(this.getNombre() + " hace un critico!");
			damage *= this.getArma().getCritico();
		}
		
		p.setVida(p.getVida() - damage);
		System.out.println(this.getNombre() + " quita " + damage + " de vida a " + p.getNombre() + " con " + this.getArma());
	}
}
