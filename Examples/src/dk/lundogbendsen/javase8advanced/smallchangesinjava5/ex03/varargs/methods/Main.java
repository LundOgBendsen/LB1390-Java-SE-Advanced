/*
 * Metoder kan som deres *sidste* parameter erklære at tage et variabelt antal
 * parametre (varargs).
 *
 * I metode-kroppen ses en vararg-variabel som et helt almindeligt array.
 * I metode-erklæaringen erklæres en vararg-variabel med ... fremfor med [].
 */
package dk.lundogbendsen.javase8advanced.smallchangesinjava5.ex03.varargs.methods;

public class Main {

	public static void main(final String[] args) {
		// "Gammel" erklæring med int[]-array som erklæring kan kun tage array
		System.out.println(sum1(new int[] { 1, 2, 3, 4 }));

		// "Ny" erklæring med varargs kan tage både varargs og/eller array
		System.out.println(sum2(1, 2, 3, 4));
		System.out.println(sum2(new int[] { 1, 2, 3, 4 }));
		System.out.println(sum3(1, 2, 3, 4));
		System.out.println(sum3(new int[] { 1, 2, 3, 4 }));
	}

	// Uden varargs-erklæring og med gammel for-løkke
	public static int sum1(final int[] ints) {
		int result = 0;
		for (int n = 0; n < ints.length; n++) {
			result += ints[n];
		}
		return result;
	}

	// Med varargs-erklæring og med gammel for-løkke
	public static int sum2(final int... ints) {
		int result = 0;
		for (int n = 0; n < ints.length; n++) {
			result += ints[n];
		}
		return result;
	}

	// Med varargs-erklæring og ny foreach-løkke
	public static int sum3(final int... ints) {
		int result = 0;
		for (int current : ints) {
			result += current;
		}
		return result;
	}
}
