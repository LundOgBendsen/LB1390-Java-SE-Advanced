package dk.lundogbendsen.javase8advanced.propertyfiles.ex05.parameterized.properties;

/*
 * Læser og lister parameteriseret property-fil.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTestEx05
{
  public static void main(String[] args)
  {
    Properties myProps = new Properties();
    File file = new File("parameterized.properties");

    // Indlæs properties
    try (FileInputStream inputStream = new FileInputStream(file);)
    {
      myProps.load(inputStream);
    }
    catch (IOException e)
    {
      String msg = "Couldn't read file 'parameterized.properties'";
      throw new RuntimeException(msg);
    }

    int sizeForA = Integer.parseInt(myProps.getProperty("array.a.length"));
    String[] a = new String[sizeForA];
    System.out.println();
    System.out.println("Size of array 'a' is: " + a.length);

    int sizeForB = Integer.parseInt(myProps.getProperty("array.b.length"));
    String[] b = new String[sizeForB];
    System.out.println();
    System.out.println("Size of array 'b' is: " + b.length);

    for (int i = 0;; i++)
    {
      String name = myProps.getProperty("person." + i + ".name");
      String sex = myProps.getProperty("person." + i + ".sex");
      if (name == null)
      {
        break;
      }
      else
      {
        System.out.println();
        System.out.println("Person no " + i + " is:");
        System.out.println("  named " + name);
        System.out.println("  a " + sex);
      }
    }
  }
}
