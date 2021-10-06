package dk.lundogbendsen.javase8advanced.generictypes.ex03.subtyping.rules;

import java.util.ArrayList;

public class Main {

	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(final String[] args) {

		ArrayList<Object> objects = null;
		ArrayList<String> strings = new ArrayList<String>();

		// IKKE tilladt, da det ville gøre det muligt at putte ulovlige
		// typer af objekter i vores ArrayList af Strings (som vist nedenfor).
		// objects = strings;
		// objects.add(Integer.valueOf(12));

		ArrayList v1 = new ArrayList();
		v1.add(1234);
		ArrayList<String> v = v1;
		String s = v.get(0);

		ArrayList v2 = new ArrayList<Integer>();
		v2.add("hdjjdj");
		v2.add(2.0);
		System.out.println(v2.get(0));
		System.out.println(v2.get(1));
	}
}
