package dk.lundogbendsen.javase8advanced.polymorphism.lab05.arithmetic.expressions;

public class ExpressionTester02 {

	public static void main(final String[] args) {

		// e1 = (3 + 2)
		Expression e1 = new Sum(new Number(3), new Number(2));

		// e2 = (4 * 3)
		Expression e2 = new Multiplication(new Number(4), new Number(3));

		// e3 = ( e1 + e2 )
		// e3 = ((3 + 2) + (4 * 3))
		Expression e3 = new Sum(e1, e2);

		System.out.println("Udtrykket : " + e3);
		System.out.println("Beregner Java til: " + e3.calculate());
	}
}