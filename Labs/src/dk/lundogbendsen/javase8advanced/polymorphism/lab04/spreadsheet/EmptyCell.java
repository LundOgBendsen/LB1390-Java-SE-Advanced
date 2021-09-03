package dk.lundogbendsen.javase8advanced.polymorphism.lab04.spreadsheet;

public class EmptyCell extends Cell
{

  private static Cell singleton = new EmptyCell();

  private EmptyCell()
  {

  }

  public static Cell getEmptyCell()
  {
    return singleton;
  }

  @Override
  public double getNumberValue()
  {
    String msg = "getNumberValue should not be called on a EmptyCell";
    throw new IllegalStateException(msg);
  }

  @Override
  public String toString()
  {
    return "";
  }
}
