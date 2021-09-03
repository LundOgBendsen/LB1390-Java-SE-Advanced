package dk.lundogbendsen.javase8advanced.propertyfiles.ex04.defaults;

/*
 * Viser at man kan angive en default-værdi, som bruges,
 * hvis den property man prøver at indlæse ikke findes
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTestEx04
{
  public static void main(String[] args)
  {
    Properties myProps = new Properties();
    File file = new File("my.properties");

    // Indlæs properties
    try (FileInputStream inputStream = new FileInputStream(file);)
    {
      myProps.load(inputStream);
    }
    catch (IOException e)
    {
      String msg = "Couldn't read file 'my.properties'";
      throw new RuntimeException(msg);
    }

    // Man kan angive en default-værdi, som bruges, hvis
    // den property man prøver at indlæse ikke findes
    String country = myProps.getProperty("country", "unknown");
    System.out.println("Property 'country' was: " + country); // Denmark

    String continent = myProps.getProperty("continent", "unknown");
    System.out.println("Property 'continent' was: " + continent); // unknown
  }
}
