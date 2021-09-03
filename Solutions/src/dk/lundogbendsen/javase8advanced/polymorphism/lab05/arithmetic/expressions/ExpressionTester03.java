package dk.lundogbendsen.javase8advanced.polymorphism.lab05.arithmetic.expressions;

public class ExpressionTester03
{

  public static void main(final String[] args)
  {

    // Beregning af udtrykket:
    // (324.0 - (((3.0 + 4.0) * 2.0) / 5.0))

    Expression e1 = new Sum(new Number(3), new Number(4));
    Expression e2 = new Multiplication(e1, new Number(2));
    Expression e3 = new Division(e2, new Number(5));
    Expression e4 = new Subtraction(new Number(324), e3);

    System.out.println("Udtrykket : " + e4);
    System.out.println("Beregner Java til: " + e4.calculate());
  }
}