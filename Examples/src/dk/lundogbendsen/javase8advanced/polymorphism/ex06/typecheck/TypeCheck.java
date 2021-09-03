package dk.lundogbendsen.javase8advanced.polymorphism.ex06.typecheck;

/*
 * Illustrerer hvad hvordan man kan lave typecheck.
 */
public class TypeCheck
{
  public static void main(final String[] args)
  {
    A a1 = new A();
    A a2 = new B();
    A a3 = new B();

    // x instanceof Y svarer på om x-objektets type svarer til eller er en
    // subtype til Y
    System.out.println("a1 instanceof A: " + (a1 instanceof A)); // true
    System.out.println("a2 instanceof A: " + (a2 instanceof A)); // true
    System.out.println("a1 instanceof B: " + (a1 instanceof B)); // false
    System.out.println("a2 instanceof B: " + (a2 instanceof B)); // true

    // x.getClass() returnerer det klasseobjekt, der udgør objektet x's klasse
    // Y.class returnerer det klasseobjekt, der repræsenterer klassen Y
    // Så vi kan spørge om et objekt er af en helt bestemt klasse
    // og ikke som ved instanceof, der også svarer true ved subtyper
    System.out.println("a1.getClass() == A.class: " + (a1.getClass() == A.class)); // true
    System.out.println("a2.getClass() == A.class: " + (a2.getClass() == A.class)); // false
    System.out.println("a1.getClass() == B.class: " + (a1.getClass() == B.class)); // false
    System.out.println("a2.getClass() == B.class: " + (a2.getClass() == B.class)); // true

    // x.getClass() returnerer det klasseobjekt, der udgør objektet x's klasse
    // Så vi kan spørge om to objekter er instanser af præcis den samme klasse
    System.out.println("a1.getClass() == a2.getClass(): " + (a1.getClass() == a2.getClass())); // false
    System.out.println("a2.getClass() == a3.getClass(): " + (a2.getClass() == a3.getClass())); // true
  }
}

class A
{
}

class B extends A
{
}
