package dk.lundogbendsen.javase8advanced.generics.lab01.point;

public class Point<T extends Number>
{

  private T x;

  private T y;

  public Point(final T x, final T y)
  {
    this.x = x;
    this.y = y;
  }

  public T getX()
  {
    return x;
  }

  public T getY()
  {
    return y;
  }

  @Override
  public String toString()
  {
    return "(" + x + ", " + y + ")";
  }
}
