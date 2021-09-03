package dk.lundogbendsen.javase8advanced.reflection.ex04.fields;

public class ClassWithFields
{
  private int a = 12;

  String str = "Hej med dig";

  public static final double PI_APPROX = 355.0 / 113.0;

  @Override
  public String toString()
  {
    String s = "";
    s += "a = " + a + "\n";
    s += "str = " + str + "\n";
    s += "PI = " + PI_APPROX;
    return s;
  }
}
