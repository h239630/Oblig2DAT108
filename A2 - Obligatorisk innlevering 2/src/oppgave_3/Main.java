package oppgave_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {

		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Karl", "Ivar", Kjonn.MANN, "Rådgiver", 457_000),
				new Ansatt("Frida", "Henriksen", Kjonn.KVINNE, "Regnskapsfører", 482_000),
				new Ansatt("Harald", "Slettemyr", Kjonn.MANN, "Leder", 803_000),
				new Ansatt("John-Willy", "Bendriksen", Kjonn.MANN, "Programmerer", 543_200),
				new Ansatt("Karianne", "Wold", Kjonn.KVINNE, "Leder", 610_900));

		// a)
		System.out.println("a)");
		List<String> etternavn = ansatte.stream()
				.map(Ansatt::getEtternavn)
				.collect(Collectors.toList());
		System.out.println(etternavn);

		// b)
		long antall = ansatte.stream()
				.filter(a -> a.getKjonn() == Kjonn.KVINNE)
				.count();
		System.out.println("\nb) \nAntall kvinner " + antall);

		// c)
		OptionalDouble snittLonn = ansatte.stream()
				.filter(a -> a.getKjonn() == Kjonn.KVINNE)
				.mapToInt(Ansatt::getAarslonn)
				.average();
		System.out.println("\nc) \nSnittlønn for kvinnene " + snittLonn.getAsDouble());

		// d)
		System.out.println("\nd) ");
		ansatte.stream()
			.filter(a -> a.getStilling().contains("Leder"))
			.forEach(a -> a.setAarslonn((int) (a.getAarslonn() * 1.07)));
		skrivUtAlle(ansatte);

		// e)
		boolean hoyLonn = ansatte.stream()
				.anyMatch(a -> a.getAarslonn() > 800_000);
		System.out.println("\ne) \nEr det noen med lønn over 800 000 kr? " + hoyLonn);

		// f)
		System.out.println("\nf)");
		ansatte.stream().forEach(System.out::println);

		// g)
		System.out.println("\ng)");
		Ansatt minLonn = ansatte.stream()
				.min(Comparator.comparing(Ansatt::getAarslonn))
				.orElseThrow(NoSuchElementException::new);
		System.out.println("Den ansatte med minst lønn er " + minLonn);

		// h)
		int sum = IntStream.range(1, 1000)
				.filter(x -> x % 3 == 0 || x % 5 == 0)
				.sum();
		System.out.println("\nh) \nSummen av alle helltall fra 1 til 1000 som er delelig på 3 og 5 er " + sum);
	}

	private static void skrivUtAlle(List<Ansatt> ansatte) {
		for (Ansatt a : ansatte) {
			System.out.println(a.toString());
		}
	}
}
