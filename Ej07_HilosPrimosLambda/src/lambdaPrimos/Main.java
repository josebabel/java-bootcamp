package lambdaPrimos;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Escribe el primer numero: ");
		int num1 = sc.nextInt();
		
		System.out.print("Escribe el segundo numero: ");
		int num2 = sc.nextInt();
		
		System.out.print("Escribe el tercer numero: ");
		int num3 = sc.nextInt();
		
		HiloPrimoLambda hPrimo1 = new HiloPrimoLambda("Hilo 1", num1);
		HiloPrimoLambda hPrimo2 = new HiloPrimoLambda("Hilo 2", num2);
		HiloPrimoLambda hPrimo3 = new HiloPrimoLambda("Hilo 3", num3);
		
		Thread h1 = new Thread(hPrimo1.esPrimo);
		Thread h2 = new Thread(hPrimo2.esPrimo);
		Thread h3 = new Thread(hPrimo3.esPrimo);
		
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
