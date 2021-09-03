/*
 * Prøv at minimere og maksimere vinduet.
 * Prøv at lukke vinduet (det lukker også programmet).
 * Prøv at klikke på knappen. Det giver output på System.out (prompt'en).
 * Prøv evt. at tilføje endnu en lytter på knappen...
 */
package dk.lundogbendsen.javase8advanced.swing.ex01.frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

	public static void main(final String[] args) {

		// Et vindue med titel-linie
		JFrame frame = new JFrame("Hello world program");

		// Sørg for hele programmet lukkes (=System.exit), når framen lukkes
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// En knap
		JButton button = new JButton("Say hello!");

		// Tilføj en lytter til knappen (knappen kalder metoden
		// actionPerformed på alle registrerede ActionListeners
		// hver gang brugeren klikker på knappen).
		button.addActionListener(e -> printHello());

		// Tilføj knappen til vinduet.
		// frame.add(button) er ikke længere nødvendigt!
		// Fra og med Java 5 kan vi nu tilføje direkte.
		frame.add(button);

		// Lad vinduet give sig selv en passende størrelse.
		// Brug alternativt frame.setSize(200, 400);
		frame.pack();

		// Sørg for programmet afsluttes, når brugeren klikker luk-vindue.
		// Normalt vil vinduet bare forsvinde, men Swing-tråden køre videre.
		// Brug alternativt frame.addWindowListener(WindowListener listener).
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Gør vinduet synligt.
		frame.setVisible(true);
	}

	public static void printHello() {
		System.out.println("Hello world from Swing button!");
	}
}
