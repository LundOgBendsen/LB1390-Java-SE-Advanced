package dk.lundogbendsen.javase_advanced.nestedtypes.ex01.visibility;

public class OuterClass {
	private static String privateString = "Hello world from OuterClass";

	public static String readPrivateField(NestedClass nestedClass) {
		return nestedClass.privateText;
	}

	public static class NestedClass {
		private String privateText = "Hello world from NestedClass";

		@Override
		public String toString() {
			return OuterClass.privateString;
		}

		public static String readPrivateField() {
			return OuterClass.privateString;
		}
	}
}