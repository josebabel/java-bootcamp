package lambda;

interface DosParametros {
	public int dosParametros(int a, int b);
}

public class Lambda {

	public static void main(String[] args) {

		DosParametros suma = (a, b) -> {
			return a + b;
		};
		DosParametros resta = (a, b) -> a - b;
		
		int res1 = suma.dosParametros(2, 3);
		System.out.println(res1);
		
		int res2 = resta.dosParametros(10, 4);
		System.out.println(res2);

	}

}
