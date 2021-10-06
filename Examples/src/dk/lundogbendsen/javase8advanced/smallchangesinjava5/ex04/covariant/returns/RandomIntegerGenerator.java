package dk.lundogbendsen.javase8advanced.smallchangesinjava5.ex04.covariant.returns;

import java.util.Random;

public class RandomIntegerGenerator implements RandomObjectGenerator {

	private static Random random = new Random();

	@Override
	public Integer generateRandomObject() {
		return random.nextInt();
	}
}
