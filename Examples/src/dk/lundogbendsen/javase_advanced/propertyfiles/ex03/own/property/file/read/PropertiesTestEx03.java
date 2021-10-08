package dk.lundogbendsen.javase_advanced.propertyfiles.ex03.own.property.file.read;

/*
 * Læser og lister egen property-fil.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTestEx03 {
	public static void main(final String[] args) {
		Properties myProps = new Properties();
		File file = new File("my.properties");
		// Indlæs properties
		try (FileInputStream inputStream = new FileInputStream(file);) {
			myProps.load(inputStream);
		} catch (IOException e) {
			String msg = "Couldn't read file 'my.properties'";
			throw new RuntimeException(msg);
		}

		Set<String> names = myProps.stringPropertyNames();

		for (String name : names) {
			String value = myProps.getProperty(name);
			System.out.println("[" + name + "=" + value + "]");
		}
	}
}
