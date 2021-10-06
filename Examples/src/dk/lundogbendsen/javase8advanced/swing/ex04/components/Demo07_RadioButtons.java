package dk.lundogbendsen.javase8advanced.swing.ex04.components;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class Demo07_RadioButtons {

	public static void main(final String[] args) {

		// Et vindue med titel-linie
		JFrame frame = new JFrame("Hello world program");
		frame.setLayout(new GridLayout(4, 1));

		// En gruppe af radio-buttons (kun én kan vælges)
		// Radio buttons grupperes vha. en Button Group
		final JRadioButton radioButton1 = new JRadioButton("Radio I");
		final JRadioButton radioButton2 = new JRadioButton("Radio II");
		final JRadioButton radioButton3 = new JRadioButton("Radio III");
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		buttonGroup.add(radioButton3);
		frame.add(radioButton1);
		frame.add(radioButton2);
		frame.add(radioButton3);
		// radioButton1.setSelected(true); // ville sætte knap 1 som default

		JButton button = new JButton("Dump state");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				// Læsning af radio-knappernes tilstand
				if (radioButton1.isSelected()) {
					System.out.println("Radio I er valgt");
				} else if (radioButton2.isSelected()) {
					System.out.println("Radio II er valgt");
				} else if (radioButton3.isSelected()) {
					System.out.println("Radio III er valgt");
				} else {
					System.out.println("Hverken Radio I eller II er valgt");
				}
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
