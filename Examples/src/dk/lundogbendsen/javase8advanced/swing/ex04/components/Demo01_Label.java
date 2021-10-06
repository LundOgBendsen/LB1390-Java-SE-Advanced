package dk.lundogbendsen.javase8advanced.swing.ex04.components;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Demo01_Label {

	public static void main(final String[] args) {

		// Et vindue med titel-linie
		JFrame frame = new JFrame("Hello world program");
		frame.setLayout(new GridLayout(2, 1));

		// En bid tekst
		JLabel label = new JLabel("This is a label");
		frame.add(label);

		JButton button = new JButton("Dump state");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("Ingen brugersat tilstand på labels");
			}
		});
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
}
