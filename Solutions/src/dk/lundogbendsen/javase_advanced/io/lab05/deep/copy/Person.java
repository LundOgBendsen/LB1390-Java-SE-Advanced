package dk.lundogbendsen.javase_advanced.io.lab05.deep.copy;

import java.io.Serializable;

class Person implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

//make it cloneable
	@Override
	public Person clone() throws CloneNotSupportedException {
		return (Person) super.clone();
	}

	Person p;
	String name;

	public Person(final String name) {
		this(name, null);
	}

	public Person(final String name, final Person p) {
		this.name = name;
		this.p = p;
	}

	public Person getP() {
		return p;
	}

	public void setP(final Person p) {
		this.p = p;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
