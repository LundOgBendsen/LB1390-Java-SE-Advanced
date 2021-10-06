package dk.lundogbendsen.javase8advanced.polymorphism.lab05.arithmetic.expressions;

public class ExpressionTester01 {

	public static void main(final String[] args) {

		// En Expression-reference kan referere til et Number-objekt,
		// da Number er en subklasse af Expression.
		Expression e1 = new Number(12);
		Expression e2 = new Number(13);

		// Constructoren i klassen Sum tager to Expression-objekter
		// (eller subtyper af Expression) som parametre.
		Sum s1 = new Sum(e1, e2);

		System.out.println("Udtrykket : " + s1);
		System.out.println("Beregner Java til: " + s1.calculate());
		System.out.println();

		// Da Sum også er en subklasse til Expression, kan vi give
		// et Sum-objekt et andet Sum-objekt som det ene argument.
		Sum s2 = new Sum(new Number(4), new Number(3));
		Sum s3 = new Sum(s2, new Number(8));
		System.out.println("Udtrykket : " + s3);
		System.out.println("Beregner Java til: " + s3.calculate());
		System.out.println();

		// Og da dette Sum-objektet s3 peger på i sig selv også
		// er en Expression, kan vi give det videre til et nyt Sum-objekt
		Sum s4 = new Sum(new Number(2), s3);
		System.out.println("Udtrykket : " + s4);
		System.out.println("Beregner Java til: " + s4.calculate());
	}
}