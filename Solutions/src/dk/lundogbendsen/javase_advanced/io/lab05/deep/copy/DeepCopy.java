package dk.lundogbendsen.javase_advanced.io.lab05.deep.copy;

import java.io.IOException;

public class DeepCopy {

	public static void main(final String[] args)
			throws IOException, ClassNotFoundException, CloneNotSupportedException {
		Person p1 = new Person("mand");
		Person p2 = new Person("dame", p1);
		p1.setP(p2);

		System.out.println("p1 klones (deep copy). p3 = den nye klon.");
		Person p3 = Cloner.deepCopy(p1);
		System.out.println("p3 == p1 : " + (p3 == p1));
		System.out.println("p3 == p2 : " + (p3 == p2));
		System.out.println("p3.get(p) == p1.getP() : " + (p3.getP() == p1.getP()));
		System.out.println("p3 : " + p3);
		System.out.println("p3.getP() : " + p3.getP());

		System.out.println("p1 klones med object klassens shallow copy metode. p4 = den nye klon");
		Person p4 = p1.clone();
		System.out.println("p4.getP() == p1.getP() : " + (p4.getP() == p1.getP()));
	}
}
