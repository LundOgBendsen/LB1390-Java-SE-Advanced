package dk.lundogbendsen.javase8advanced.swing.ex04.components;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Demo05_ComboBox {

	public static void main(final String[] args) {

		// Et vindue med titel-linie
		JFrame frame = new JFrame("Hello world program");
		frame.setLayout(new GridLayout(2, 1));

		// En dropdown-liste
		final JComboBox<String> comboBox = new JComboBox<>();
		String item0 = "Item 0";
		String item1 = "Item 1";
		String item2 = "Item 2";
		comboBox.addItem(item0);
		comboBox.addItem(item1);
		comboBox.addItem(item2);
		frame.add(comboBox);

		JButton button = new JButton("Dump state");
		button.addActionListener((final ActionEvent e) -> {
			System.out.println("Combobox value is " + comboBox.getSelectedItem());
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
