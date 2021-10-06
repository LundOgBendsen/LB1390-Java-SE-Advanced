package dk.lundogbendsen.javase8advanced.commonmethods.lab01.standard.methods;

public class Person {
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
		// TODO Ret denne metode til
		return null;
	}

	public int compareTo(final Person other) {
		// TODO Ret denne metode til
		return 0;
	}

}
