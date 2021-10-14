package interfaces;

public interface Movible {
	
	default void mover(int metros) {
		
		System.out.println(this + " se ha movido " + metros + "m");
	}

}
