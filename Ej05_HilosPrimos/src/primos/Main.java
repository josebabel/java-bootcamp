package primos;

public class Main {

	public static void main(String[] args) {

		HiloPrimo h1, h2, h3;
		
		h1 = new HiloPrimo("Hilo 1", 1);
		h2 = new HiloPrimo("Hilo 2", 71);
		h3 = new HiloPrimo("Hilo 3", 52);
		
		h1.start();
		h2.start();
		h3.start();
		
		try {
			h1.join();
			h2.join();
			h3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Tareas finalizadas");
	
	}
}
