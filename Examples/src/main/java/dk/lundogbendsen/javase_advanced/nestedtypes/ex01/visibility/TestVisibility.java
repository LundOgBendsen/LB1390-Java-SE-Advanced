/*
  * Indicates that a nested class NestedClass is declared within OuterClass
  * can see each other's private fields!!!
  */
package dk.lundogbendsen.javase_advanced.nestedtypes.ex01.visibility;

public class TestVisibility {
	public static void main(final String[] args) {

		@SuppressWarnings("unused")
		OuterClass outer = new OuterClass();
		OuterClass.NestedClass nested = new OuterClass.NestedClass();

		System.out.println(OuterClass.NestedClass.readPrivateField());
		System.out.println(OuterClass.readPrivateField(nested));

	}
}
