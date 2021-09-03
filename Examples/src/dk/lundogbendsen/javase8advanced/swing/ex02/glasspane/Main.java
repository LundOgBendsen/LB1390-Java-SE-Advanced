package dk.lundogbendsen.javase8advanced.swing.ex02.glasspane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

	public static void main(final String[] args) {

		// Et vindue med titel-linie
		JFrame frame = new JFrame("Panes");

		// Sørg for hele programmet lukkes (=System.exit), når framen lukkes
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// En knap
		JButton button = new JButton("Say hello!");

		// Tilføj knappen til vinduet.
		frame.add(button, BorderLayout.CENTER);

		// Lav et nyt glass pane og brug det fremfor default glass pane'et
		// JComponent er supertype for alle former for widgets i Swing.
		JComponent glassPane = new JComponent() {

			private static final long serialVersionUID = 1L;

			// kaldes af Swing, når komponenten skal tegne sig selv
			@Override
      protected void paintComponent(final Graphics g) {
				g.setColor(Color.RED);
        g.drawLine(0, 0, 200, 100);
        g.drawLine(200, 100, 100, 100);
        g.drawLine(100, 100, 75, 75);
        g.drawLine(75, 75, 100, 50);
			}
		};
		frame.setGlassPane(glassPane);
		// Sørg for glass pane'et er synligt (det er det ikke per default)
		glassPane.setVisible(true);

		// Lad vinduet give sig selv en passende størrelse.
		frame.setSize(200, 200);

		// Sørg for programmet afsluttes, når brugeren klikker luk-vindue.
		// Normalt vil vinduet bare forsvinde, men Swing-tråden køre videre.
		// Brug alternativt frame.addWindowListener(WindowListener listener).
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Gør vinduet synligt.
		frame.setVisible(true);
	}
}
