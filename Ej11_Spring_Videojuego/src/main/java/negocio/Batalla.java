package negocio;

import entities.Personaje;

public class Batalla {
	
	private Personaje p1;
	private Personaje p2;
	
	public void empezar() {
		
		Personaje pInicial;
		Personaje pFinal;
		
		int moneda = (int)(Math.random() * 2);
		
		if(moneda == 1) {
			pInicial = p1;
			pFinal = p2;
		} else {
			pInicial = p2;
			pFinal = p1;
		}
		
		do {
			pInicial.ataca(pFinal);
			pFinal.ataca(pInicial);
			System.out.println(pInicial.getNombre() + " | Vida: " + pInicial.getVida());
			System.out.println(pFinal.getNombre() + " | Vida: " + pFinal.getVida() + "\n");
			
			if(pInicial.getVida() <= 0) {
				System.out.println(pFinal.getNombre() + " gana el combate!!");
			} else if(pFinal.getVida() <= 0) {
				System.out.println(pInicial.getNombre() + " gana el combate!!");
			}
			
		} while(pInicial.getVida() > 0 && pFinal.getVida() > 0);
		
	}

	public Personaje getP1() {
		return p1;
	}

	public Personaje getP2() {
		return p2;
	}

	public void setP1(Personaje p1) {
		this.p1 = p1;
	}

	public void setP2(Personaje p2) {
		this.p2 = p2;
	}

	
}
