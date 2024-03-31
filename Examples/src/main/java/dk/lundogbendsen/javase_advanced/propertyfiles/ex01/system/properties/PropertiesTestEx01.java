package dk.lundogbendsen.javase_advanced.propertyfiles.ex01.system.properties;

/*
 * Viser opslag af system-værdien 'user.home'.
 */
import java.util.Properties;

public class PropertiesTestEx01 {
	public static void main(String[] args) {
		// Første måde at læse en system property på
		String userHome1 = System.getProperty("user.home");
		System.out.println("User home is in dir " + userHome1);

		// Anden måde at læse en system property på
		Properties systemProps = System.getProperties();
		String userHome2 = systemProps.getProperty("user.home");
		System.out.println("User home is in dir " + userHome2);
	}
}