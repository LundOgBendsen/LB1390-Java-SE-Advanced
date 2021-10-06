package dk.lundogbendsen.javase8advanced.generics.lab02.wildcards;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestCollectionUtil {

	public static void main(final String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("hello there");
		l.add("here");
		l.add("are");
		l.add("some long");
		l.add("and short");
		l.add("words");

		// Collection<String> c = CollectionUtil.getLongWords(l);
		// System.out.println(c);

		List<StringBuffer> l2 = new LinkedList<StringBuffer>();
		l2.add(new StringBuffer("hello there"));
		l2.add(new StringBuffer("here"));
		l2.add(new StringBuffer("are"));
		l2.add(new StringBuffer("some long"));
		l2.add(new StringBuffer("and short"));
		l2.add(new StringBuffer("words"));

		// Collection<StringBuffer> c2 = CollectionUtil.getLongWords(l2);
		// System.out.println(c2);
	}
}
