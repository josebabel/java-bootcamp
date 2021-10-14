package primos;

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
		
		HiloPrimo h1, h2, h3;
		
		h1 = new HiloPrimo("Hilo 1", num1);
		h2 = new HiloPrimo("Hilo 2", num2);
		h3 = new HiloPrimo("Hilo 3", num3);
		
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
