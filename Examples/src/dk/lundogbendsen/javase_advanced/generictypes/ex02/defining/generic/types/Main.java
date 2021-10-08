package dk.lundogbendsen.javase_advanced.generictypes.ex02.defining.generic.types;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {

		Number n1 = Integer.valueOf(5);
		String s1 = new String("Goddag");

		// Virker fordi vi overholder typerne på vores Pair-instans
		Pair<Number, String> p1 = new Pair<Number, String>(n1, s1);

		// Også lovligt, fordi vi igen overholder typerne på vores Pair-instans
		p1.setFirst(Long.valueOf(6L));
		p1.setSecond(new String("Hello"));

		// Ikke lovligt, da vi bryder med de typeparametre, som vi har angivet:
		// p1.setFirst("Hej");

		Trio<String, String, String> trio;
		trio = new Trio<String, String, String>("H", "e", "j");

		// new NumberPair<String, Integer>("Hej",5);
	}
}
