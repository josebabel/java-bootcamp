package videojuego;

public class Main {

	public static void main(String[] args) {
		
		Espada espada = new Espada();
		Arco arco = new Arco();
		Hechizo hechizo = new Hechizo();
		Rezo rezo = new Rezo();
		
		Guerrero p1 = new Guerrero("Hercules", 200, espada);	
		Mago p2 = new Mago("Dynamo", 200, hechizo);
		//Curandero p2 = new Curandero("Sabio", 200, rezo);
		
		do {
			p1.ataca(p2);
			p2.ataca(p1);
			System.out.println(p1.getNombre() + " | Vida: " + p1.getVida());
			System.out.println(p2.getNombre() + " | Vida: " + p2.getVida() + "\n");
			
			if(p1.getVida() <= 0) {
				System.out.println(p2.getNombre() + " gana el combate!!");
			} else if(p2.getVida() <= 0) {
				System.out.println(p1.getNombre() + " gana el combate!!");
			}
			
		} while(p1.getVida() > 0 && p2.getVida() > 0);
		
		
		
	}

}
