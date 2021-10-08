package dk.lundogbendsen.javase_advanced.enumerations.ex03.enumerations.are.self.documenting;

/**
 * Demonstrates that enums are much more self-documenting than booleans
 */
public class EnumsAreSelfDocumenting {
	/* if you want to make boolean descriptive, you have to define a constant anyway */
	private static final boolean GENDER_MALE = true;
	
	public static void main(String[] args) {
		new EnumsAreSelfDocumenting().setGender(GENDER_MALE);
		/* nothing prevents people from using the raw type anyway */
		new EnumsAreSelfDocumenting().setGender(true);
		
		/* Enum ensures readability */
		new EnumsAreSelfDocumenting().setGender(Gender.MALE);
	}
	
	public void setGender(boolean gender) {
		
	}
	
	public void setGender(Gender gender) {
		
	}
}


enum Gender  {
	MALE, FEMALE, OTHER;
}