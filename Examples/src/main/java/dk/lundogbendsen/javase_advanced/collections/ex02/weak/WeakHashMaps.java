package dk.lundogbendsen.javase_advanced.collections.ex02.weak;

/*
 * Example of how to use a WeakHashMap.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMaps {
	private static final int N = 100;
	private static final int LUMP = 1000000;

	public static void main(final String[] args) throws Exception {
		final Map<Integer, Object[]> weakHashMap = new WeakHashMap<>();
		final List<Integer> ids = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			final Integer id = Integer.valueOf(i + 500);
			weakHashMap.put(id, new Object[LUMP]);
			ids.add(id);
		}

		System.out.println("\nweakHashMap now has " + weakHashMap.size() + " elements");

		System.out.println("\nWe remove 50% of the keys");
		for (int i = N - 1; i >= 0; i -= 2) {
			ids.remove(i);
		}

		System.out.println("\nweakHashMap now has " + weakHashMap.size() + " elements");

		System.out.println("\nWe politely ask for garbage collection");
		System.gc();

		System.out.println("\nweakHashMap now has " + weakHashMap.size() + " elements");

		System.out.println("\nWe now fill the memory with other elements, to trigger the clean up of the deleted keys");

		ArrayList<Object[]> big = new ArrayList<Object[]>();

		while (true) {
			try {
				big.add(new Object[LUMP]);
				if (big.size() % 100 == 0) {
					System.gc();
					if (weakHashMap.size() == 50) {
						break;
					}
				}

			} catch (OutOfMemoryError e) {
				System.out.println("...og nu løb vi tør for memory...");
				break;
			}
		}

		// This demonstrates, that the keys were removed from the map, even though we never deleted them (directly)
		System.out.println("\nweakHashMap now has " + weakHashMap.size() + " elements");
	}
}