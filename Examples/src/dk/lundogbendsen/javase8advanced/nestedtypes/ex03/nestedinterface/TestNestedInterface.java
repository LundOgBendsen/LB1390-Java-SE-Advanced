package dk.lundogbendsen.javase8advanced.nestedtypes.ex03.nestedinterface;

public class TestNestedInterface {

	public static void main(String[] args) {
		OuterClass.MemberInterface ref = new SubType();
		ref.printMsg();

		@SuppressWarnings("unused")
		OuterInterface.MemberClass mc = new OuterInterface.MemberClass();
	}
}

class OuterClass {
	// interfacet bliver implicit static, fordi det er interface.
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
	// klassen bliver implicit static fordi den er erklæret i et interface.
	class MemberClass {

	}
}