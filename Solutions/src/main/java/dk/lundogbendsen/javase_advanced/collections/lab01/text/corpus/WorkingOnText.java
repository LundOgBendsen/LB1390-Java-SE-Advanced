package dk.lundogbendsen.javase_advanced.collections.lab01.text.corpus;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class WorkingOnText {

	public static void main(final String[] args) {
		List<String> textUnits = Text.getTextAsLinkedList();

		// Øvelse 1
		HashSet<String> hashSet = new HashSet<String>(textUnits);
		System.out.println(hashSet.size());

		// Øvelse 2
		TreeSet<String> treeSet = new TreeSet<String>(textUnits);
		System.out.println(treeSet);

		// Øvelse 3
		LinkedList<String> linkedList = new LinkedList<String>(textUnits);
		Collections.sort(linkedList);
		System.out.println(linkedList);

		// Øvelse 4
		TreeSet<String> treeSet2 = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(final String s1, final String s2) {
				return s1.compareToIgnoreCase(s2);
			}
		});
		treeSet2.addAll(textUnits);
		System.out.println(treeSet2);

		// Øvelse 5
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		Iterator<String> i = textUnits.iterator();
		while (i.hasNext()) {
			String current = i.next();
			Integer count = treeMap.get(current);
			if (count == null) {
				count = 1; // autoboxing
			} else {
				count += 1; // autounboxing og så boxing igen
			}
			treeMap.put(current, count);
		}
		System.out.println(treeMap);

		// Øvelse 6
		TreeSet<Map.Entry<String, Integer>> treeSet3 = new TreeSet<Map.Entry<String, Integer>>(
				new Comparator<Map.Entry<String, Integer>>() {
					@Override
					public int compare(final Map.Entry<String, Integer> e1, final Map.Entry<String, Integer> e2) {
						Integer count1 = e1.getValue();
						String textUnit1 = e1.getKey();
						Integer count2 = e2.getValue();
						String textUnit2 = e2.getKey();
						int countCompare = count1.compareTo(count2);
						if (countCompare != 0) {
							return countCompare;
						}
						return textUnit1.compareToIgnoreCase(textUnit2);
					}
				});
		treeSet3.addAll(treeMap.entrySet());
		System.out.println(treeSet3);

		// Øvelse 7.1 (alle i x som ikke er i y)
		LinkedList<String> x1 = new LinkedList<String>();
		x1.add("A");
		x1.add("B");
		LinkedList<String> y1 = new LinkedList<String>();
		y1.add("B");
		y1.add("C");
		LinkedList<String> z1 = new LinkedList<String>();
		z1.addAll(x1);
		z1.removeAll(y1);
		System.out.println(z1);

		// Øvelse 7.2 (fællesmængden mellem x og y)
		LinkedList<String> x2 = new LinkedList<String>();
		x2.add("A");
		x2.add("B");
		LinkedList<String> y2 = new LinkedList<String>();
		y2.add("B");
		y2.add("C");
		LinkedList<String> z2 = new LinkedList<String>();
		z2.addAll(x2);
		z2.retainAll(y2);
		System.out.println(z2);

		// Øvelse 7.3 (foreningsmængden mellem x og y)
		LinkedList<String> x3 = new LinkedList<String>();
		x3.add("A");
		x3.add("B");
		LinkedList<String> y3 = new LinkedList<String>();
		y3.add("B");
		y3.add("C");
		LinkedList<String> z3 = new LinkedList<String>();
		z3.addAll(x3);
		z3.addAll(y3);
		System.out.println(z3);
	}
}
