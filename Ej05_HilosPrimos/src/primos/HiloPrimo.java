package primos;

public class HiloPrimo extends Thread{

	private int number;

	public HiloPrimo(String nombre, int number) {
		super(nombre);
		this.number = number;
	}
	
	
	@Override
	public void run() {
		
		long inicio = System.currentTimeMillis();
         
		int contador = 2;
		boolean primo = true;
		while ((primo) && (contador != number)) {
			if (number % contador == 0) {
				primo = false;	
			}	
			contador++;
		}
		
		long fin = System.currentTimeMillis();
		long tiempo = ((fin - inicio)/1000);
		
		System.out.println(getName() + " | Num: " + number +  " Primo: " + primo + " | Tiempo de procesamiento: " + tiempo + "s");
	}
	
}
