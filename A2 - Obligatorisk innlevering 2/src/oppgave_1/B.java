package oppgave_1;

import java.util.function.BiFunction;

public class B {
	
	
	public static int beregn (int a, int b, BiFunction<Integer, Integer, Integer> f) {
		return f.apply(a, b);
	}

	public static void main(String[] args) {
		
		// i. 
		BiFunction<Integer,Integer,Integer> sumFunksjon = (x, y) -> x + y;
		
		int sum = beregn(12, 13, sumFunksjon); 
		
		System.out.println("Summen av 12 og 13 er " + sum);
		
		// ii.
		BiFunction<Integer,Integer,Integer> st�rstFunksjon = (x, y) -> Integer.max(x, y);
		
		int st�rst = beregn(-5, 3, st�rstFunksjon);
		
		System.out.println("Den st�rste av -5 og 3 er " + st�rst);
		
		// iii.
		BiFunction<Integer,Integer,Integer> avstandFunksjon = (x, y) -> Math.abs(x - y);

		int avstand = beregn(54, 45, avstandFunksjon);
		
		System.out.println("Den avstanden mellom 54 og 45 er " + avstand);
	}

}
