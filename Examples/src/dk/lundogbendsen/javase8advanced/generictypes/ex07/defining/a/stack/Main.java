package dk.lundogbendsen.javase8advanced.generictypes.ex07.defining.a.stack;

public class Main {

	public static void main(String[] args) {
		Stack<Integer> numberStack = new StackImpl<Integer>();
		numberStack.push(new Integer(4));
		numberStack.push(new Integer(98));
		numberStack.push(456); // Og vi kan endda bruge autoboxing

		// Men... det her går ikke
		// numberStack.push(new Double(4.4));

		Integer i01 = numberStack.pop(); // Uden downcast!!
		System.out.println(i01);

		int i02 = numberStack.pop(); // Og med auto-unboxing
		System.out.println(i02);

		System.out.println(numberStack.pop());
	}
}
