package entities;

public class Guerrero extends Personaje {

	private int fuerza;
	
	public Guerrero() {
		// TODO Auto-generated constructor stub
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	
	@Override
	public String toString() {
		return  "Guerrero "  + super.toString() + "[fuerza=" + fuerza + "]";
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
