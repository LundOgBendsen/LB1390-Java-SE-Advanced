package dk.lundogbendsen.javase8advanced.nestedtypes.ex06.localinnerclass;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sentence {
	private String[] words;

	public Sentence(String[] words) {
		this.words = words;
	}

	public Iterator<String> iterate() {
		return iterate(0);
	}

	// bemærk final parameter
	public Iterator<String> iterate(final int fromWord) {

		return new Iterator<String>() {
			// kan bruge final lokal var / param
			int current = fromWord;

			@Override
			public boolean hasNext() {
				// kan se klassens felter
				return current < words.length;
			}

			@Override
			public String next() {
				if (hasNext()) {
					return words[current++];
				} else {
					throw new NoSuchElementException();
				}
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};

	}
}