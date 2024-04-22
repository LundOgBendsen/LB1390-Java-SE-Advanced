package dk.lundogbendsen.javase_advanced.nestedtypes.ex03.nestedinterface;

public class TestNestedInterface {

	public static void main(String[] args) {
		OuterClass.MemberInterface ref = new SubType();
		ref.printMsg();

		@SuppressWarnings("unused")
		OuterInterface.MemberClass mc = new OuterInterface.MemberClass();
	}
}

class OuterClass {
	// implicit static interface
	interface MemberInterface {
		void printMsg();
	}
}

class SubType implements OuterClass.MemberInterface {
	@Override
	public void printMsg() {
		System.out.println("Message");
	}
}

interface OuterInterface {
	// the class becomes implicitly static because it is declared in an interface.
	class MemberClass {

	}
}