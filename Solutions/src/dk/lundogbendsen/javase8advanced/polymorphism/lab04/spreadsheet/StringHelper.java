package dk.lundogbendsen.javase8advanced.polymorphism.lab04.spreadsheet;

public class StringHelper
{

  public static String createSpaces(final int howMany)
  {
    String result = "";
    for (int n = 0; n < howMany; n++)
    {
      result += " ";
    }
    return result;
  }

  public static String createLine(final int howLong)
  {
    String result = "";
    for (int n = 0; n < howLong; n++)
    {
      result += "-";
    }
    return result;
  }

  public static String setStringLength(final String s, final int howLong)
  {
    String result;
    if (s.length() > howLong)
    {
      result = s.substring(0, howLong - 3) + "...";
    }
    else
      if (s.length() == howLong)
      {
        result = s;
      }
      else
      {
        result = createSpaces(howLong - s.length());
        result += s;
      }
    return result;
  }
}
