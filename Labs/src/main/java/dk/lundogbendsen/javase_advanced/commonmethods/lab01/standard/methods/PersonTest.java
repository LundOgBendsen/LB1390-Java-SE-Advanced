package dk.lundogbendsen.javase_advanced.commonmethods.lab01.standard.methods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class PersonTest {
	static Person p1 = new Person(true, "Hans Jensen", 82.5, 1972);

	// p2 is equal to p1
	static Person p2 = new Person(true, "Hans Jensen", 82.5, 1972);

	// p1 is male and p3 is female
	static Person p3 = new Person(false, "Hans Jensen", 82.5, 1972);

	// p1.name = Hans Jensen and p4.name = Jens Jensen
	static Person p4 = new Person(true, "Jens Jensen", 82.5, 1972);

	// p1.birthYear = 1972 and p5.birthYear = 1980
	static Person p5 = new Person(true, "Hans Jensen", 82.5, 1980);

	// p1.name = Hans Jensn and p6.name = null
	static Person p6 = new Person(true, null, 82.5, 1972);

	// p1 is of type Person and p7 is a subtype of Person
	static Person p7 = new Person(true, "Hans Jensen", 82.5, 1972) {

		@SuppressWarnings("unused")
		private int height = 200;

		@Override
		public boolean equals(final Object other) {
			return super.equals(other);
		}
	};

	@Test
	public void testEquals() {
		assertEquals(p1, p2, "Not the same object");

		assertEquals( p1, p2, "Not equal objects");

		assertNotEquals(p1, p3, "Equal sexes");

		// p1.name = Hans Jensen and p4.name = Jens Jensen
		assertNotEquals(p1, p4, "Equal names");

		// p1.birthYear = 1972 and p5.birthYear = 1980
		assertNotEquals(p1, p5,"Equal ages");

		// p1.name = Hans Jensen and p6.name = null
		assertNotEquals(p1, p6, "Ignored null");

		assertNotEquals(p1, p7, "Ignored types");

		assertNotEquals(p1, null, "Ignored null");
	}

	@Test
	public void testHashCode() {
		assertEquals(p1.hashCode(), p1.hashCode(), "Different hashcodes");

		assertEquals(p1.hashCode(), p2.hashCode(), "Not equal object");

		assertNotEquals(p1.hashCode(), p3.hashCode(), "Equal sexes");

		assertNotEquals(p1.hashCode(), p4.hashCode(), "Equal names");

		assertNotEquals(p1.hashCode(), p5.hashCode(), "Equal ages");

		assertNotEquals(p1.hashCode(), p6.hashCode(), "Ignored null name");
	}

	@Test
	public void testClone() throws Exception {
		Person original = new Person(true, "Hans Jensen", 82.5, 1972);
		Person clone = original.clone();

		assertFalse(original == clone, "Not same object");

		assertTrue(original.equals(clone), "Not queals");

		Person notCloneable = new Person(true, "Hans Jensen", 82.5, 1972) {
			@Override
			public Person clone() throws CloneNotSupportedException {
				throw new CloneNotSupportedException();
			}
		};
		try {
			notCloneable.clone();
			fail("Clone not disallowed");
		} catch (CloneNotSupportedException e) {
		}
	}

	@Test
	public void testCompareTo() {
		assertEquals(0, p1.compareTo(p1), "Not equal to myself");

		assertEquals(0, p1.compareTo(p2), "Not equal objects");

		assertTrue(0 > p1.compareTo(p3), "Male not < female");

		assertTrue(0 > p1.compareTo(p3), "Hans Jensen not < Jens Jensen");

		assertTrue(0 < p1.compareTo(p5), "young not < old");

		assertTrue(0 < p1.compareTo(p6), "name == null not < name != null");

		try {
			p1.compareTo(p7);
			fail("Ignored subtype");
		} catch (ClassCastException e) {
		}
	}
}
