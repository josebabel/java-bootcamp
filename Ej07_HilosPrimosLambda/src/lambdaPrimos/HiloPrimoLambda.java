package lambdaPrimos;

public class HiloPrimoLambda {
	/**
	 * Propiedad privada <b>nombre</b> de HiloPrimoLambda
	 */
	private String nombre;
	
	/**
	 * Propiedad privada <b>number</b> de HiloPrimoLambda
	 */
	private int number;
	
	/**
	 * Constructor de la clase HiloPrimoLambda
	 * @param nombre String
	 * @param number int
	 */
	public HiloPrimoLambda(String nombre, int number) {
		this.nombre = nombre;
		this.number = number;
	}
	
	/**
	 * Metodo run de la interfaz Runnable al cual le pasamos nuestra propia implementacion con un expresion lambda,
	 * en este caso "run" (esPrimo) comprobara si un numero es primo o no
	 */
	public Runnable esPrimo = () -> {
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
		
		System.out.println(getNombre() + " | Num: " + number +  " Primo: " + primo + " | Tiempo de procesamiento: " + tiempo + "s");
	};

	/**
	 * Metodo getter de propiedad nombre
	 * @return String nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo getter de propiedad number
	 * @return int number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Metodo setter de propiedad nombre
	 * @param nombre String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo setter de propiedad number
	 * @param number int
	 */
	public void setNumber(int number) {
		this.number = number;
	}
}
