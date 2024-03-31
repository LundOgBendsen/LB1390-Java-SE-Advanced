package dk.lundogbendsen.javase_advanced.propertyfiles.ex02.all.properties;

/*
 * Lister alle system-værdier.
 */
import java.util.Properties;
import java.util.Set;

public class PropertiesTestEx02 {
	public static void main(String[] args) {
		Properties systemProps = System.getProperties();

		Set<String> nameSet = systemProps.stringPropertyNames();

		for (String name : nameSet) {
			String value = systemProps.getProperty(name);
			System.out.println("[" + name + "=" + value + "]");
		}
	}
}
