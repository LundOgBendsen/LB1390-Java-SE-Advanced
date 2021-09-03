package dk.lundogbendsen.javase8advanced.polymorphism.lab05.arithmetic.expressions;

public class Number implements Expression
{

  private double number;

  public Number(final double number)
  {
    this.number = number;
  }

  @Override
  public String toString()
  {
    return "" + number;
  }

  @Override
  public double calculate()
  {
    return number;
  }
}
