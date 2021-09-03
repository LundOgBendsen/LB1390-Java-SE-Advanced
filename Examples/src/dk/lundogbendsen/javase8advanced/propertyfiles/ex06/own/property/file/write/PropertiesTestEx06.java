package dk.lundogbendsen.javase8advanced.propertyfiles.ex06.own.property.file.write;

/*
 * Laver en Properties-instans, gemmer properties i den
 * og gemmer til sidst dens indhold i en tekstfil.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTestEx06
{
  public static void main(String[] args)
  {
    Properties myProps = new Properties();

    myProps.setProperty("username", "SYSDBA");
    myProps.setProperty("password", "MASTERKEY");

    File file = new File("saved.properties");

    // Gem properties i fil
    try (FileOutputStream outputStream = new FileOutputStream(file);)
    {
      String titleComments = "Password properties";
      myProps.store(outputStream, titleComments);
    }
    catch (IOException e)
    {
      String msg = "Couldn't write file 'saved.properties'";
      throw new RuntimeException(msg);
    }
  }
}
