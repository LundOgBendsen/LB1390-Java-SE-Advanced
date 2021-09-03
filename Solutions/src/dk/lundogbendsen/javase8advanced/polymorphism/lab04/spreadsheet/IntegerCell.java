package dk.lundogbendsen.javase8advanced.polymorphism.lab04.spreadsheet;

public class IntegerCell extends Cell
{

  private int value;

  public IntegerCell(final int value)
  {
    this.value = value;
  }

  @Override
  public double getNumberValue()
  {
    return value;
  }

  @Override
  public String toString()
  {
    return "" + value;
  }
}
