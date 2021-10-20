package entities;

public class Mago extends Personaje{
	
	private int inteligencia;

	public Mago() {
		// TODO Auto-generated constructor stub
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	@Override
	public String toString() {
		return "Mago " + super.toString() + "[inteligencia=" + inteligencia + "]";
	}

	@Override
	public void ataca(Personaje p) {
		int damage = this.getArma().getDamage();
		int criticoRandom = (int)(Math.random() * 100); 
		
		if(this.getArma() instanceof Hechizo) {
			damage += this.getInteligencia();
		}
		
		if(criticoRandom <= this.getProbabilidadCritico()) {
			System.out.println(this.getNombre() + " hace un critico!");
			damage *= this.getArma().getCritico();
		}
		
		p.setVida(p.getVida() - damage);
		System.out.println(this.getNombre() + " quita " + damage + " de vida a " + p.getNombre() + " con " + this.getArma());	
	}
	
}
