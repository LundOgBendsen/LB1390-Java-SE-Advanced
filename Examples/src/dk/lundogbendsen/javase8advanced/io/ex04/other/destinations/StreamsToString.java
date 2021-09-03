package dk.lundogbendsen.javase8advanced.io.ex04.other.destinations;

/*
 * Viser hvordan man kan lave streams til programmets
 * egen hukommelse - her i form af en String
 */
import java.io.*;

public class StreamsToString
{
  public static void main(String[] args) throws IOException
  {
    // OUTPUT TO String
    StringWriter sw = new StringWriter();
    sw.write("Hej ");
    sw.write("med ");
    sw.write("dig!");

    String s = sw.toString();

    // INPUT FROM String
    StringReader sr = new StringReader(s);
    String newString = "";
    while (true)
    {
      int i = sr.read();
      if (i == -1)
      {
        break;
      }
      else
      {
        newString += "" + (char) i;
      }
    }

    System.out.println("Value read from StringReader: " + newString);
  }
}