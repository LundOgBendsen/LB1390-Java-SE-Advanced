package dk.lundogbendsen.javase_advanced.nestedtypes.ex06.localinnerclass;

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

	// Notice final parameter
	// Also notice overloaded method
	public Iterator<String> iterate(final int startIndex) {
		class MyLocalInnerClass implements Iterator<String> {
			int index = startIndex;

			@Override
			public boolean hasNext() {
				// see the class fields
				return index < words.length;
			}

			@Override
			public String next() {
				if (hasNext()) {
					return words[index++];
				} else {
					throw new NoSuchElementException();
				}
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		}

		return new MyLocalInnerClass();
	}

//	public Iterator<String> iterate(final int startIndex) {
//		return new Iterator<String>() {
//			int index = startIndex;
//
//			@Override
//			public boolean hasNext() {
//				// see the class fields
//				return index < words.length;
//			}
//
//			@Override
//			public String next() {
//				if (hasNext()) {
//					return words[index++];
//				} else {
//					throw new NoSuchElementException();
//				}
//			}
//
//			@Override
//			public void remove() {
//				throw new UnsupportedOperationException();
//			}
//		};
//	}
}