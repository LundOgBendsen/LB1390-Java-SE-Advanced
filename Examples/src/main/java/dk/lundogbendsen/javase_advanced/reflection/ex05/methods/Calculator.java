package dk.lundogbendsen.javase_advanced.reflection.ex05.methods;

public class Calculator {

	public int add(final int a, final int b) {
		return a + b;
	}

	@SuppressWarnings("unused")
	private int add(final int[] ints) {
		int sum = 0;
		for (int i = 0; i < ints.length; i++) {
			sum += ints[i];
		}
		return sum;
	}
}
