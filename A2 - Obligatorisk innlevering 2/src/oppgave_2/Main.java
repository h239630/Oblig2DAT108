package oppgave_2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
	
	
	private static void lonnsOppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> f) {
		for (Ansatt a : ansatte) {
			a.setAarslonn(f.apply(a));
		}
	}

	public static void main(String[] args) {
		
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Karl", "Ivar", Kjonn.MANN, "R�dgiver", 457_000),
				new Ansatt("Frida", "Henriksen", Kjonn.KVINNE, "Regnskapsf�rer", 482_000),
				new Ansatt("Harald", "Slettemyr", Kjonn.MANN, "Leder", 670_000),
				new Ansatt("John-Willy", "Bendriksen", Kjonn.MANN, "Programmerer", 543_200),
				new Ansatt("Karianne", "Wold", Kjonn.KVINNE, "Markedsf�rer", 610_900));
		
//		skrivUtAlle(ansatte);
//		System.out.println("------------------------------------------");
//		
		
		// i. 	Et fast kronetillegg
		Function<Ansatt, Integer> fastKroneTillegg = a -> a.getAarslonn() + 10_000;
		lonnsOppgjor(ansatte, fastKroneTillegg);
		
		System.out.println("i. �ker alle ansattes l�nn med 10 000 kr");
		skrivUtAlle(ansatte);
		System.out.println("------------------------------------------");

				
		// ii.	Et fast prosenttillegg
		Function<Ansatt, Integer> fastProsentTillegg = a -> (int)(a.getAarslonn() * 1.03);
		lonnsOppgjor(ansatte, fastProsentTillegg);
		
		System.out.println("ii. �ker alle ansattes l�nn med 3 %");
		skrivUtAlle(ansatte);
		System.out.println("------------------------------------------");
		
		
		// iii.	Et fast kronetilleg hvis du har lav l�nn
		
		Function<Ansatt, Integer> lavLonnFastKroneTillegg = a -> { 
				if (a.getAarslonn() < 500_000) {
					return a.getAarslonn() + 10_000;
					} else {
						return a.getAarslonn();
					}
				};
		lonnsOppgjor(ansatte, lavLonnFastKroneTillegg);
		
		System.out.println("iii. Ansatte med l�nn under 500 000 kr �kes med 10 000 kr");
		skrivUtAlle(ansatte);
		System.out.println("------------------------------------------");
		
		// iv. 	Et fast prosenttillegg hvis du er mann
		Function<Ansatt, Integer> prosentTilleggForMenn = a -> { 
			if (a.getKjonn() == Kjonn.MANN) {
				return (int) (a.getAarslonn() * 1.03);
				} else {
					return a.getAarslonn();
				}
			};
		lonnsOppgjor(ansatte, prosentTilleggForMenn);
		
		System.out.println("iv. Mannlige ansatte sin l�nn �kes med 3 %");
		skrivUtAlle(ansatte);
		System.out.println("------------------------------------------");
			
		
	}
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		for (Ansatt a : ansatte) {
			System.out.println(a.toString());
		}
	}

}