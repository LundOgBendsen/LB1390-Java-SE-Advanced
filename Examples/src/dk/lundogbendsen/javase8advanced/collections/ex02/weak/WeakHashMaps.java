package dk.lundogbendsen.javase8advanced.collections.ex02.weak;

/*
 * Viser brugen WeakHashMap.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMaps {
	private static final int N = 100;
	private static final int LUMP = 1000000;

	public static void main(final String[] args) throws Exception {
		Map<Integer, Object[]> weakHashMap = new WeakHashMap<>();
		List<Integer> ids = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			Integer id = Integer.valueOf(i + 500);
			weakHashMap.put(id, new Object[LUMP]);
			ids.add(id);
		}

		System.out.println("\nweakHashMap har nu " + weakHashMap.size() + " elementer");

		System.out.println("\nVi fjerner referencer til halvdelen af nøglerne");
		for (int i = N - 1; i >= 0; i -= 2) {
			ids.remove(i);
		}

		System.out.println("\nweakHashMap har nu " + weakHashMap.size() + " elementer");

		System.out.println("\nVi opfordrer garbage collectoren til at køre.");
		System.gc();

		System.out.println("\nweakHashMap har nu " + weakHashMap.size() + " elementer");

		System.out.println("\nNu fylder vi memory op med andre elementer");

		ArrayList<Object[]> big = new ArrayList<Object[]>();

		while (true) {
			try {
				big.add(new Object[LUMP]);
			} catch (OutOfMemoryError e) {
				System.out.println("...og nu løb vi tør for memory...");
				break;
			}
		}
		System.out.println("\nweakHashMap har nu " + weakHashMap.size() + " elementer");

	}
}