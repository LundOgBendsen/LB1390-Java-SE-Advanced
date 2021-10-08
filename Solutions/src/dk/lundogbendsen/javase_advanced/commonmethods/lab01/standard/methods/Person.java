package dk.lundogbendsen.javase_advanced.commonmethods.lab01.standard.methods;

public class Person implements Cloneable, Comparable<Person> {
	private boolean isMale;

	private String name;

	private double weight;

	private int birthYear;

	public Person(final boolean isMale, final String name, final double weight, final int birthYear) {

		this.isMale = isMale;
		this.name = name;
		this.weight = weight;
		this.birthYear = birthYear;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(final int birthYear) {
		this.birthYear = birthYear;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(final boolean isMale) {
		this.isMale = isMale;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(final double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		String result = "Person[name=" + name + ", weight=" + weight;
		result += ", birthYear=" + birthYear + ", isMale=" + isMale + "]";
		return result;
	}

	@Override
	protected Person clone() throws CloneNotSupportedException {
		return (Person) super.clone();
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Person other = (Person) obj;

		return (this.isMale == other.isMale) && safeEquals(this.name, other.name) && this.weight == other.weight
				&& this.birthYear == other.birthYear;
	}

	private boolean safeEquals(final Object o1, final Object o2) {
		if (null == o1 && null == o2)
			return true;
		if (null == o1 && null != o2)
			return false;
		if (null != o1 && null == o2)
			return false;
		if (null != o1 && null != o2)
			return o1.equals(o2);

		throw new RuntimeException("Impossible...");
	}

	@Override
	public int hashCode() {
		int result = 17;

		// for hvert boolean felt:
		result = 37 * result + (isMale ? 0 : 1);

		// for hvert referencefelt:
		if (name == null) {
			result = 37 * result;
		} else {
			result = 37 * result + name.hashCode();
		}

		// for hvert double felt:
		long temp = Double.doubleToLongBits(weight);
		result = 37 * result + (int) (temp ^ (temp >>> 32));

		// for hvert byte, char, short eller int-felt:
		result = 37 * result + birthYear;

		return result;
	}

	@Override
	public int compareTo(final Person o) {
		if (o == null) {
			throw new NullPointerException("Parameter obj was null");
		}
		if (this == o) {
			return 0;
		}
		if (this.getClass() != o.getClass()) {
			String msg = "The parameter obj has a different type than this";
			throw new ClassCastException(msg);
		}
		if (this.isMale && (!o.isMale)) {
			// this er male, hvilket er mindre end other, der er female
			return -1;
		} else if ((!this.isMale) && o.isMale) {
			// this er female, hvilket er større end other, der er male
			return 1;
		}

		int nameCompare;
		if (this.name == null) {
			nameCompare = -1;
		} else if (o.name == null) {
			nameCompare = 1;
		} else {
			nameCompare = this.name.compareTo(o.name);
		}
		if (nameCompare != 0) {
			// A er mindre end B
			return nameCompare;
		}

		double weightCompare = (this.weight - o.weight);
		// Negativ, hvis this vejer mindre end other
		if (weightCompare < 0) {
			return -1;
		} else if (weightCompare > 0) {
			return 1;
		}
		int ageCompare = (o.birthYear - this.birthYear);
		// Negativ, hvis this er yngre end other (fx
		if (ageCompare != 0) {
			return ageCompare;
		} else {
			return 0;
		}
	}

}
