package dk.lundogbendsen.javase_advanced.enumerations.ex03.enumerations.are.self.documenting;

/**
 * Demonstrates that enums are much more self-documenting than booleans
 */
public class EnumsAreSelfDocumenting {
	/* if you want to make boolean descriptive, you have to define a constant anyway */
	private static final int GENDER_MALE = 3;

	public static void main(String[] args) {
		new EnumsAreSelfDocumenting().setGender(GENDER_MALE);
		/* nothing prevents people from using the raw type anyway */
		new EnumsAreSelfDocumenting().setGender(42);

		/* Enum ensures readability */
		new EnumsAreSelfDocumenting().setGender(Gender.MALE);
	}

	public void setGender(int gender) {

	}

	public void setGender(Gender gender) {

	}
}

enum Gender {
	MALE, FEMALE, OTHER;
}