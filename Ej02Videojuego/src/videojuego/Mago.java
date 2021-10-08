package videojuego;

public class Mago extends Personaje{
	
	private int inteligencia;

	public Mago(String nombre, int vida, Arma arma) {
		super.setNombre(nombre);
		super.setVida(vida);
		super.setArma(arma);
		super.setProbabilidadCritico(20);
		this.inteligencia = 10;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	@Override
	public String toString() {
		return super.toString() + " Mago [inteligencia=" + inteligencia + "]";
	}

	@Override
	public void ataca(Personaje p) {
		int damage = this.getArma().getDamage();
		int criticoRandom = (int)(Math.random() * 100); 
		
		if(this.getArma() instanceof Hechizo) {
			damage += this.getInteligencia();
		}
		
		if(criticoRandom < this.getProbabilidadCritico()) {
			System.out.println(this.getNombre() + " hace un critico!");
			damage *= this.getArma().getCritico();
		}
		
		p.setVida(p.getVida() - damage);
		System.out.println(this.getNombre() + " quita " + damage + " de vida a " + p.getNombre() + " con " + this.getArma());	
	}
	
}
