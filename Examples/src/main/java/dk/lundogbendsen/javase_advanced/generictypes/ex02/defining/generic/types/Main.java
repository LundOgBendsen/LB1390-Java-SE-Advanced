package dk.lundogbendsen.javase_advanced.generictypes.ex02.defining.generic.types;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {

		Number n1 = Integer.valueOf(5);
		String s1 = new String("Hi");

		// Works, as the parameterised types defined matches our supplied arguments
		Pair<Number, String> p1 = new Pair<Number, String>(n1, s1);

		// Still valid
		p1.setFirst(Long.valueOf(6L));
		p1.setSecond(new String("Hello"));

		// Below statement is NOT valid, as the first parameterised type was defined to be of type Number
		// p1.setFirst("Bye");

		Trio<String, String, String> trio;
		trio = new Trio<String, String, String>("H", "e", "j");

		// Below statement is NOT valid, as a NumberPair only allows types extending the Number class
		// new NumberPair<String, Integer>("Hi",5);
	}
}
