package dk.lundogbendsen.javase_advanced.nestedtypes.ex05.innerclass;

public class WhichMethod {

	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();
		inner.callPrint();
	}
}

class BaseClassForInner {
	public void print() {
		System.out.println("BaseClassForInner");
	}
}

class BaseClassForOuter {
	public void print() {
		System.out.println("BaseClassForOuter");
	}
}

class OuterClass extends BaseClassForOuter {

	@Override
	public void print() {
		System.out.println("OuterClass");
	}

	public class InnerClass extends BaseClassForInner {
		public void callPrint() {
			// which print method is executed here?
			print();

			// best to use of the following:
			super.print();
			OuterClass.this.print();

			// Check this out :-)
			OuterClass.super.print();
		}
	}
}