package dk.lundogbendsen.javase_advanced.generictypes.ex08.generic.methods;

import java.util.ArrayList;
import java.util.List;

public class MyTest {

	public static void testUpperBound(List<? extends Number> numbers) {

		for (int i = 0; i < numbers.size(); i++) {
			Number n = numbers.get(i);
			System.out.println(n.doubleValue());
		}

	}

	public static void main(String[] args) {

		List<Integer> integers = new ArrayList<Integer>();
		integers.add(7);
		integers.add(9);
		integers.add(13);
		testUpperBound(integers);
	}
}
