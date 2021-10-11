package videojuego;

public class Curandero extends Personaje {

	private int sabiduria;

	public Curandero(String nombre, int vida, Arma arma) {
		super.setNombre(nombre);
		super.setVida(vida);
		super.setArma(arma);
		super.setProbabilidadCritico(10);
		this.sabiduria = 10;
	}

	public int getSabiduria() {
		return sabiduria;
	}

	public void setSabiduria(int sabiduria) {
		this.sabiduria = sabiduria;
	}

	@Override
	public String toString() {
		return super.toString() + " Curandero [sabiduria=" + sabiduria + "]";
	}

	@Override
	public void ataca(Personaje p) {
		int damage = this.getArma().getDamage();
		int criticoRandom = (int)(Math.random() * 100); 
		
		if(this.getArma() instanceof Rezo) {
			damage += this.getSabiduria();
		}
		
		if(criticoRandom <= this.getProbabilidadCritico()) {
			System.out.println(this.getNombre() + " hace un critico!");
			damage *= this.getArma().getCritico();
		}
		
		p.setVida(p.getVida() - damage);
		System.out.println(this.getNombre() + " quita " + damage + " de vida a " + p.getNombre() + " con " + this.getArma());
	}
	
	
}
